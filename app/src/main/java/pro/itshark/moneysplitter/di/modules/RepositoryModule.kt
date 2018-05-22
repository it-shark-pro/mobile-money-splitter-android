package pro.itshark.moneysplitter.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.model.UserLocalStorage
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.repository.EventCreator
import pro.itshark.moneysplitter.model.repository.EventRepository
import pro.itshark.moneysplitter.model.repository.UserRepository
import javax.inject.Singleton
import pro.itshark.moneysplitter.model.repository.events.EventsLoader
import pro.itshark.moneysplitter.model.repository.events.EventsRepository

@Module
class RepositoryModule {

    @Provides
    fun provideUserRepository(application: Application): UserRepository = UserLocalStorage(application)

    @Provides
    @Singleton
    fun provideNewEventRepository(api: Api): EventRepository = EventCreator(api)

    @Provides
    fun provideEventsRepository() : EventsRepository = EventsLoader();
}
