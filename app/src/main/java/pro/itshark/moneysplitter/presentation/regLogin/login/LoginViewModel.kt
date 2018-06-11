package pro.itshark.moneysplitter.presentation.regLogin.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.itshark.moneysplitter.domain.user.UserUseCases
import pro.itshark.moneysplitter.model.pojo.UserEntry
import javax.inject.Inject

class LoginViewModel
@Inject constructor(private val userUseCases: UserUseCases) : ViewModel() {
    val stateLiveData = MutableLiveData<LoginScreenState>()
    val credits = LoginModel()
    val isRequestSuccess: ObservableField<Boolean> = ObservableField(false)

    var testCreditsClickCounter = 0

    fun onLoginButtonClick() {
        isRequestSuccess.set(false)
        stateLiveData.value = LoginRequestSendState()

        val credits = UserEntry(email = credits.email, password = credits.password)
        userUseCases.login(credits)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoginSuccess, this::onError)
    }

    private fun onLoginSuccess(userEntry: UserEntry) {
        isRequestSuccess.set(false)
        stateLiveData.value = LoginSuccessState(userEntry)
        userUseCases.saveUserInfo(userEntry)
    }

    private fun onError(error: Throwable) {
        isRequestSuccess.set(true)
        stateLiveData.value = LoginErrorState(error.localizedMessage)
    }

    fun onSetTestCreditsButtonClick() {
        testCreditsClickCounter++
        stateLiveData.value = LoginSetTestCreditsState(testCreditsClickCounter)
    }
}