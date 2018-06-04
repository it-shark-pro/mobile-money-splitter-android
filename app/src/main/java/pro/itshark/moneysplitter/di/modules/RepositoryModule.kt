package pro.itshark.moneysplitter.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.model.UserDownloader
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.repository.EventCreator
import pro.itshark.moneysplitter.model.repository.EventRepository
import pro.itshark.moneysplitter.model.repository.UserRepository
import pro.itshark.moneysplitter.model.repository.events.EventsLoader
import pro.itshark.moneysplitter.model.repository.events.EventsRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(application: Application, api: Api): UserRepository = UserDownloader(application, api)

    @Provides
    @Singleton
    fun provideNewEventRepository(api: Api): EventRepository = EventCreator(api)

    @Provides
    @Singleton
    fun provideEventsRepository(api: Api) : EventsRepository = EventsLoader(api)
}
