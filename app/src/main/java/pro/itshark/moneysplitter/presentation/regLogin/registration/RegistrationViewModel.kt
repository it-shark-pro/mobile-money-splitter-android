package pro.itshark.moneysplitter.presentation.regLogin.registration

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.itshark.moneysplitter.domain.user.UserUseCases
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginErrorState
import javax.inject.Inject

class RegistrationViewModel
@Inject constructor(private val userUseCases: UserUseCases): ViewModel() {
    val regCredits = RegistrationModel()
    val stateLiveData = MutableLiveData<RegistrationScreenStates>()

    fun onRegisterButtonClick() {
        val credits = UserEntry.create(regCredits)
        userUseCases.register(credits)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onRegistrationSuccess, this::onError)
    }

    private fun onRegistrationSuccess(userEntry: UserEntry){
        stateLiveData.value = RegistrationSuccessState()
    }

    private fun onError(error: Throwable) {
        stateLiveData.value = RegistrationErrorState()
    }

    fun showErrorMsg(): Boolean {
        return stateLiveData.value is RegistrationErrorState
    }
}
