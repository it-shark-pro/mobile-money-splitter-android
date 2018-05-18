package pro.itshark.moneysplitter.di

import dagger.Component
import pro.itshark.moneysplitter.App
import pro.itshark.moneysplitter.di.modules.NetworkModule
import pro.itshark.moneysplitter.di.modules.NewEventModule
import pro.itshark.moneysplitter.di.modules.ViewModelFactoryModule
import pro.itshark.moneysplitter.di.modules.ViewModelModule
import pro.itshark.moneysplitter.presentation.newevent.NewEventActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        NewEventModule::class,
        NewEventActivityModule::class
))
interface AppComponent {
    fun inject(app: App)
}