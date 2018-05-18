package pro.itshark.moneysplitter.di.modules

import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.presentation.regLogin.RegLoginActivity
import pro.itshark.moneysplitter.presentation.regLogin.RegLoginActivityViewModel
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginActions
import javax.inject.Singleton

@Module
class ActionsModule {
    @Provides
    @Singleton
    fun provideRegLoginActions(): LoginActions = RegLoginActivityViewModel()
}