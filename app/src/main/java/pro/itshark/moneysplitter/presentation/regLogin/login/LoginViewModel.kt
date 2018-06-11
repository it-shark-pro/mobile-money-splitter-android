package pro.itshark.moneysplitter.presentation.regLogin.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.itshark.moneysplitter.domain.users.UsersUseCases
import pro.itshark.moneysplitter.model.pojo.UserEntry
import javax.inject.Inject

class LoginViewModel
@Inject constructor(private val usersUseCases: UsersUseCases): ViewModel() {
    val stateLiveData = MutableLiveData<LoginScreenState>()

    val credits = LoginModel()

    fun login() {
        val credits = UserEntry(email = credits.email, password = credits.password)
        usersUseCases.login(credits)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoginSuccess, this::onError)
    }

    private fun onLoginSuccess(userEntry: UserEntry) {
        usersUseCases.saveUserInfo(userEntry)
        stateLiveData.value = LoginSuccessState(userEntry)
    }

    private fun onError(error: Throwable) {
        stateLiveData.value = LoginErrorState(error.localizedMessage)
    }

    fun showErrorMsg(): Boolean {
        return stateLiveData.value is LoginErrorState
    }
}