package pro.itshark.moneysplitter.presentation.userProfile

import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.itshark.moneysplitter.domain.UserUseCases
import javax.inject.Inject

class UserProfileViewModel
@Inject constructor(private val userUseCases: UserUseCases) : ViewModel() {

    var user = UserModel()

    init {
        getUserInfo()
    }

    fun getUserInfo() {
        userUseCases.getUserInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ user ->
                    this.user.update(user)
                }, { error ->
                    error.printStackTrace()
                })
    }
}
