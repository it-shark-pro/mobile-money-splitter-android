package pro.itshark.moneysplitter.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.model.UserLocalStorage
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.repository.UserRepository
import pro.itshark.moneysplitter.model.repository.events.EventsRepository
import pro.itshark.moneysplitter.model.repository.events.EventsRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(application: Application): UserRepository = UserLocalStorage(application)

    @Provides
    @Singleton
    fun provideNewEventRepository(api: Api): EventsRepository = EventsRepositoryImpl(api)
}
