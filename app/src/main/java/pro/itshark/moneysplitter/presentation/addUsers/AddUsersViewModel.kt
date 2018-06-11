package pro.itshark.moneysplitter.presentation.addUsers

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import pro.itshark.moneysplitter.EMPTY_STRING
import pro.itshark.moneysplitter.Timeout
import pro.itshark.moneysplitter.domain.friends.FriendsUseCases
import pro.itshark.moneysplitter.domain.users.UsersUseCases
import pro.itshark.moneysplitter.presentation.userProfile.UserModel
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AddUsersViewModel
@Inject constructor(private val friendsUseCases: FriendsUseCases, private val usersUseCases: UsersUseCases) : ViewModel() {

    val stateViewModel = MutableLiveData<State>()
    val isUserListEmpty = ObservableBoolean(false)
    val subject = PublishSubject.create<String>()

    private var usersList = listOf<UserModel>()
    private var selectedUsers: MutableMap<Long, UserModel> = mutableMapOf()

    private var email = EMPTY_STRING
    private var token = EMPTY_STRING

    init {
        stateViewModel.value = State.Default(usersList)

        initSubject()
        getUserInfo()
    }

    fun setSelectedUsers(selectedUsers: Map<Long, UserModel>) {
        this.selectedUsers = selectedUsers.toMutableMap()
    }

    fun getSelectedUsers(): Map<Long, UserModel> = selectedUsers

    fun onConfirmClick() {
        stateViewModel.value = State.Confirm(usersList)
    }

    private fun getUserInfo() {
        usersUseCases.getUserInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it ->
                    email = it.email
                    token = it.token

                    getAllFriends()
                }, { error ->
                    loadError(error)
                })
    }

    private fun initSubject() {
        subject
                .debounce(Timeout.debounce, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .switchMap {
                    if (it.isEmpty()) friendsUseCases.getAllFriends(email, token)
                    else usersUseCases.searchUsers(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it ->
                    loadSuccess(it)
                }, { error ->
                    loadError(error)
                    initSubject()
                })
    }

    private fun getAllFriends() {
        friendsUseCases.getAllFriends(email, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::loadSuccess, this::loadError)
    }

    private fun loadSuccess(usersList: List<UserModel>) {
        this.usersList = usersList

        isUserListEmpty.set(usersList.isEmpty())
        stateViewModel.value = State.Success(usersList)
    }

    private fun loadError(e: Throwable) {
        stateViewModel.value = State.Error(usersList, e.toString())
    }

    sealed class State {
        abstract val usersList: List<UserModel>

        data class Default(override val usersList: List<UserModel>) : State()
        data class Loading(override val usersList: List<UserModel>) : State()
        data class Success(override val usersList: List<UserModel>) : State()
        data class Error(override val usersList: List<UserModel>, val errorMessage: String) : State()
        data class Confirm(override val usersList: List<UserModel>) : State()
    }
}
