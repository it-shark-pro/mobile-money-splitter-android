package pro.itshark.moneysplitter.presentation.regLogin.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.Scheduler
import pro.itshark.moneysplitter.di.modules.SCHEDULER_IO
import pro.itshark.moneysplitter.di.modules.SCHEDULER_MAIN_THREAD
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.model.pojo.UserEntry
import javax.inject.Inject
import javax.inject.Named

class LoginViewModel
@Inject constructor(private val userUseCases: UserUseCases, @Named(SCHEDULER_IO) val subscribeOnScheduler:Scheduler, @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler) : ViewModel() {

    val stateLiveData = MutableLiveData<LoginScreenState>()

    fun login(email: String, password: String) {
        userUseCases.login(email, password)
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(this::onLoginSucces, this::onError)
    }

    /*private fun register(credits: UserEntry) {
        userUseCases.register(credits)
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe()
    }*/

    private fun onLoginSucces(userEntry: UserEntry) {
        Log.d("TestPish", "onLoginSucces")
        stateLiveData.value = SuccessState(UserEntry())
    }

    private fun onError(error: Throwable) {
        Log.d("TestPish", "onError " +error.localizedMessage)
        stateLiveData.value = ErrorState(error.message!!, UserEntry())
    }



}