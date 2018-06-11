package pro.itshark.moneysplitter.presentation.regLogin

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginActions
import pro.itshark.moneysplitter.presentation.regLogin.registration.RegistrationActions
import javax.inject.Inject

class RegLoginViewModel
@Inject constructor() : ViewModel(), LoginActions, RegistrationActions {
    val stateLiveData = MutableLiveData<RegLoginState>()
    val showProgressBar: ObservableField<Boolean> = ObservableField(false)

    init {
        stateLiveData.value = OpenLoginState()
    }

    override fun onOpenLogin() {
        stateLiveData.value = OpenLoginState()
    }

    override fun onOpenRegistration() {
        stateLiveData.value = OpenRegistrationState()
    }

    override fun onRequestSend() {
        showProgressBar.set(true)
    }

    override fun onResponseGet() {
        showProgressBar.set(false)
    }
}
