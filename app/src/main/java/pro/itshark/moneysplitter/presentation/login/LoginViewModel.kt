package pro.itshark.moneysplitter.presentation.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.Scheduler
import pro.itshark.moneysplitter.di.modules.SCHEDULER_IO
import pro.itshark.moneysplitter.di.modules.SCHEDULER_MAIN_THREAD
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.model.pojo.User
import javax.inject.Inject
import javax.inject.Named

class LoginViewModel
@Inject constructor(private val userUseCases: UserUseCases, @Named(SCHEDULER_IO) val subscribeOnScheduler:Scheduler, @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler) : ViewModel() {

    val stateLiveData = MutableLiveData<LoginScreenState>()

    fun login(credits: User) {
        userUseCases.login(credits)
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(this::onLoginSucces, this::onError)
    }

    /*private fun register(credits: User) {
        userUseCases.register(credits)
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe()
    }*/

    private fun onLoginSucces(loginUserViewModel: LoginUserViewModel) {
        Log.d("TestPish", "onLoginSucces")
        stateLiveData.value = SuccessState(User())
    }

    private fun onError(error: Throwable) {
        Log.d("TestPish", "onError " +error.localizedMessage)
        stateLiveData.value = ErrorState(error.message!!, User())
    }



}