package pro.itshark.moneysplitter.di

import dagger.Component
import pro.itshark.moneysplitter.di.modules.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

}