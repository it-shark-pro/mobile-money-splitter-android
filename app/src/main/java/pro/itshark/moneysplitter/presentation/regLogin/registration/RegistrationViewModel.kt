package pro.itshark.moneysplitter.presentation.regLogin.registration

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import pro.itshark.moneysplitter.domain.UserUseCases
import javax.inject.Inject

class RegistrationViewModel
@Inject constructor(private val userUseCases: UserUseCases): ViewModel() {

    val stateLiveData = MutableLiveData<RegistrationScreenStates>()

    private fun onBackToLoginButtonClick() {

    }

    fun onRegisterButtonClick() {
/*        userUseCases.register(credits)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()*/
    }
}
