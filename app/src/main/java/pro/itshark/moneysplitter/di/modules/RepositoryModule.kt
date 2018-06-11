package pro.itshark.moneysplitter.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.repository.events.EventsRepository
import pro.itshark.moneysplitter.model.repository.events.EventsRepositoryImpl
import pro.itshark.moneysplitter.model.repository.friends.FriendsLoader
import pro.itshark.moneysplitter.model.repository.friends.FriendsRepository
import pro.itshark.moneysplitter.model.repository.users.UsersLoader
import pro.itshark.moneysplitter.model.repository.users.UsersRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUsersRepository(application: Application, api: Api): UsersRepository = UsersLoader(application, api)

    @Provides
    @Singleton
    fun provideNewEventRepository(api: Api): EventsRepository = EventsRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideFriendsRepository(api: Api): FriendsRepository = FriendsLoader(api)
}
