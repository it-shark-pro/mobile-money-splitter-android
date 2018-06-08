package pro.itshark.moneysplitter.presentation.regLogin.registration

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.itshark.moneysplitter.domain.user.UserUseCases
import pro.itshark.moneysplitter.model.pojo.UserEntry
import javax.inject.Inject

class RegistrationViewModel
@Inject constructor(private val userUseCases: UserUseCases) : ViewModel() {
    val regCredits = RegistrationModel()
    val stateLiveData = MutableLiveData<RegistrationScreenStates>()
    val requestFailed: ObservableField<Boolean> = ObservableField(false)

    fun onRegisterButtonClick() {
        requestFailed.set(false)
        stateLiveData.value = RegistrationRequestSendState()

        val credits = UserEntry.create(regCredits)
        userUseCases.register(credits)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onRegistrationSuccess, this::onError)
    }

    private fun onRegistrationSuccess(userEntry: UserEntry) {
        requestFailed.set(false)
        stateLiveData.value = RegistrationSuccessState()
    }

    private fun onError(error: Throwable) {
        requestFailed.set(true)
        stateLiveData.value = RegistrationErrorState()
    }
}
