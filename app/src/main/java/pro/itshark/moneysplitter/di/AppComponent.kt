package pro.itshark.moneysplitter.di

import android.app.Application
import dagger.Component
import pro.itshark.moneysplitter.App
import pro.itshark.moneysplitter.di.modules.NetworkModule
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.presentation.EventsActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(api: Api)

    fun inject(eventsActivity: EventsActivity)
}