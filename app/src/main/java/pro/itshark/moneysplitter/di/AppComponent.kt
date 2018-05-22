package pro.itshark.moneysplitter.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import pro.itshark.moneysplitter.App
import pro.itshark.moneysplitter.di.modules.NetworkModule
import pro.itshark.moneysplitter.di.modules.NewEventModule
import pro.itshark.moneysplitter.di.modules.ViewModelFactoryModule
import pro.itshark.moneysplitter.di.modules.ViewModelModule
import pro.itshark.moneysplitter.presentation.newevent.NewEventActivityModule
import pro.itshark.moneysplitter.di.modules.*
import pro.itshark.moneysplitter.presentation.userProfile.UserProfileActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        NewEventModule::class,
        UseCasesModule::class,
        RepositoryModule::class,
        NewEventActivityModule::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(userProfileActivity: UserProfileActivity)
    fun inject(app: App)
}
