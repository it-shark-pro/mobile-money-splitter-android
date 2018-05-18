package pro.itshark.moneysplitter.presentation.regLogin.registration

import android.arch.lifecycle.ViewModel
import io.reactivex.Scheduler
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.model.pojo.UserEntry

class RegistrationViewModel(private val userUseCases: UserUseCases, private val subscribeOnScheduler: Scheduler, private val observeOnScheduler: Scheduler): ViewModel() {
    private fun register(credits: UserEntry) {
        /*userUseCases.register(credits)
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe()*/
    }
}