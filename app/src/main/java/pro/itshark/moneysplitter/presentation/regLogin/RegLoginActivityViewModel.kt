package pro.itshark.moneysplitter.presentation.regLogin

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginActions
import pro.itshark.moneysplitter.presentation.regLogin.registration.RegistrationActions
import javax.inject.Inject

class RegLoginActivityViewModel
@Inject constructor() : ViewModel(), LoginActions, RegistrationActions {

    val stateLiveData = MutableLiveData<RegLoginState>()

    init {
        stateLiveData.value = OpenLoginState()
    }

    override fun onOpenLogin() {
        stateLiveData.value = OpenLoginState()
    }

    override fun onOpenRegistration() {
        stateLiveData.value = OpenRegistrationState()
    }
}
