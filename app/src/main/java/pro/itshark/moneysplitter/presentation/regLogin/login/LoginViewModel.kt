package pro.itshark.moneysplitter.presentation.regLogin.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.itshark.moneysplitter.domain.users.UsersUseCases
import pro.itshark.moneysplitter.model.pojo.UserEntry
import javax.inject.Inject

class LoginViewModel

@Inject constructor(private val usersUseCases: UsersUseCases): ViewModel() {
    val stateLiveData = MutableLiveData<LoginScreenState>()
    val credits = LoginModel()
    val isResponseSuccess: ObservableField<Boolean> = ObservableField(true)

    var testCreditsClickCounter = 0

    fun onLoginButtonClick() {
        isResponseSuccess.set(true)
        stateLiveData.value = LoginRequestSendState()

        val credits = UserEntry(email = credits.email, password = credits.password)
        usersUseCases.login(credits)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoginSuccess, this::onError)
    }

    private fun onLoginSuccess(userEntry: UserEntry) {
        isResponseSuccess.set(true)
        stateLiveData.value = LoginSuccessState(userEntry)
        usersUseCases.saveUserInfo(userEntry)
    }

    private fun onError(error: Throwable) {
        isResponseSuccess.set(false)
        stateLiveData.value = LoginErrorState(error.localizedMessage)
    }

    fun onSetTestCreditsButtonClick() {
        testCreditsClickCounter++
        stateLiveData.value = LoginSetTestCreditsState(testCreditsClickCounter)
    }
}