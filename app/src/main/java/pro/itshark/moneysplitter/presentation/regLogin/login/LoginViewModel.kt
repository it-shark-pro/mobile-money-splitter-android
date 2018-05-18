package pro.itshark.moneysplitter.presentation.regLogin.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.Scheduler
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.model.pojo.UserEntry
import javax.inject.Inject

class LoginViewModel(private val userUseCases: UserUseCases, private val subscribeOnScheduler: Scheduler, private val observeOnScheduler: Scheduler, private val loginActions: LoginActions): ViewModel() {

/*    @Inject
    lateinit var loginActions: LoginActions*/

    val stateLiveData = MutableLiveData<LoginScreenState>()

    fun login(email: String, password: String) {
        userUseCases.login(email, password)
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(this::onLoginSucces, this::onError)
    }

    fun register() {
        loginActions.onOpenRegistration()
        //stateLiveData.value = OpenRegistrationState()
    }

    private fun onLoginSucces(userEntry: UserEntry) {
        Log.d("TestPish", "openMain")
        stateLiveData.value = SuccessState(UserEntry())
    }

    private fun onError(error: Throwable) {
        Log.d("TestPish", "onError " +error.localizedMessage)
        stateLiveData.value = ErrorState(error.message!!, UserEntry())
    }



}