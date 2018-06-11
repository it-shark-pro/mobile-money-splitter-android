package pro.itshark.moneysplitter.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import pro.itshark.moneysplitter.App
import pro.itshark.moneysplitter.di.modules.*
import pro.itshark.moneysplitter.presentation.addUsers.AddUsersActivityModule
import pro.itshark.moneysplitter.presentation.events.EventsActivityModule
import pro.itshark.moneysplitter.presentation.events.newevent.NewEventActivityModule
import pro.itshark.moneysplitter.presentation.regLogin.RegLoginModule
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginModule
import pro.itshark.moneysplitter.presentation.regLogin.registration.RegistrationModule
import pro.itshark.moneysplitter.presentation.userProfile.UserProfileActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (NetworkModule::class),
    (ViewModelFactoryModule::class),
    (ViewModelModule::class),
    (UseCasesModule::class),
    (RepositoryModule::class),
    (EventsActivityModule::class),
    (RegLoginModule::class),
    (LoginModule::class),
    (RegistrationModule::class),
    (ActionsModule::class),
    (NewEventActivityModule::class),
    (UserProfileActivityModule::class),
    (AddUsersActivityModule::class)
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
