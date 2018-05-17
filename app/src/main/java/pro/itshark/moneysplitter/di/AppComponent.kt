package pro.itshark.moneysplitter.di

import dagger.Component
import pro.itshark.moneysplitter.di.modules.*
import pro.itshark.moneysplitter.presentation.login.LoginActivity
import pro.itshark.moneysplitter.presentation.login.LoginFragment
import pro.itshark.moneysplitter.presentation.login.LoginViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class), (UseCasesModule::class), (ApplicationModule::class), (ViewModelModule::class), (RepositoryModule::class)])

interface AppComponent {

    fun inject(loginViewModel: LoginViewModel)
    fun inject(loginFragment: LoginFragment)
}