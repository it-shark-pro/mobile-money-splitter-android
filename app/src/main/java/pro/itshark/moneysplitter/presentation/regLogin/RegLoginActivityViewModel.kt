package pro.itshark.moneysplitter.presentation.regLogin

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginActions

class RegLoginActivityViewModel: ViewModel(), LoginActions {
    val stateLiveData = MutableLiveData<RegLoginState>()

/*    override fun onOpenLogin() {
        stateLiveData.value = OpenLoginState()
    }*/

    override fun onOpenRegistration() {
        stateLiveData.value = OpenRegistrationState()
    }

    override fun onOpenMain() {
        //stateLiveData.value = OpenMainState()
    }
}