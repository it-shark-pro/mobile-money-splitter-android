package pro.itshark.moneysplitter.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.domain.events.EventsInteractor
import pro.itshark.moneysplitter.domain.events.EventsUseCases
import pro.itshark.moneysplitter.domain.friends.FriendsInteractor
import pro.itshark.moneysplitter.domain.friends.FriendsUseCases
import pro.itshark.moneysplitter.domain.users.UsersInteractor
import pro.itshark.moneysplitter.domain.users.UsersUseCases
import pro.itshark.moneysplitter.model.repository.events.EventsRepository
import pro.itshark.moneysplitter.model.repository.friends.FriendsRepository
import pro.itshark.moneysplitter.model.repository.users.UsersRepository

@Module
class UseCasesModule {

    @Provides
    fun provideUsersUseCases(usersRepository: UsersRepository): UsersUseCases = UsersInteractor(usersRepository)

    @Provides
    fun provideEventUseCases(eventRepository: EventsRepository, app: Application): EventsUseCases = EventsInteractor(eventRepository, app)

    @Provides
    fun provideFriendsUseCases(friendsRepository: FriendsRepository): FriendsUseCases = FriendsInteractor(friendsRepository)
}
