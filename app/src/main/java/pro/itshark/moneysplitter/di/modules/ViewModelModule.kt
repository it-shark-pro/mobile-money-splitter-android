package pro.itshark.moneysplitter.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.presentation.regLogin.RegLoginActivityViewModel
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginViewModel
import javax.inject.Named

@Module
class ViewModelModule {

    @Provides
    fun bindLoginViewModel(userUseCases: UserUseCases,
                           @Named(SCHEDULER_IO) subscribeOnScheduler: Scheduler,
                           @Named(SCHEDULER_MAIN_THREAD) observeOnScheduler: Scheduler,
                           regLoginActivityViewModel: RegLoginActivityViewModel) = LoginViewModel(userUseCases, subscribeOnScheduler, observeOnScheduler, regLoginActivityViewModel)
}