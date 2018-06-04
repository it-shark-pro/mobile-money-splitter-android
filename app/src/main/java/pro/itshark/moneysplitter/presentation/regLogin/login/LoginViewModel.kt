package pro.itshark.moneysplitter.presentation.regLogin.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.model.pojo.UserEntry
import javax.inject.Inject

class LoginViewModel
@Inject constructor(private val userUseCases: UserUseCases): ViewModel() {
    val stateLiveData = MutableLiveData<LoginScreenState>()

    fun login() {

/*        userUseCases.login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoginSucces, this::onError)*/
    }

    private fun onLoginSucces(userEntry: UserEntry) {
        stateLiveData.value = LoginSuccessState(UserEntry())
    }

    private fun onError(error: Throwable) {
        stateLiveData.value = LoginErrorState(error.localizedMessage)
    }

    private fun onEmailTextChanged(text: String) {
        Log.d("TextPish", "onnEmailTextChanged = " +text)
    }
}