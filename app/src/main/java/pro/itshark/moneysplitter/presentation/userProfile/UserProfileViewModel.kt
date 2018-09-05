package pro.itshark.moneysplitter.presentation.userProfile

import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.itshark.moneysplitter.domain.users.UsersUseCases
import javax.inject.Inject

class UserProfileViewModel
@Inject constructor(private val usersUseCases: UsersUseCases) : ViewModel() {

    val user = UserModel()

    init {
        getUserInfo()
    }

    fun getUserInfo() {
        usersUseCases.getUserInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ user ->
                    this.user.update(user)
                }, { error ->
                    error.printStackTrace()
                })
    }
}
