package pro.itshark.moneysplitter.di.modules

import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.domain.EventInteractor
import pro.itshark.moneysplitter.domain.EventUseCases
import pro.itshark.moneysplitter.domain.UserInteractor
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.model.repository.EventRepository
import pro.itshark.moneysplitter.domain.events.EventsInteractor
import pro.itshark.moneysplitter.domain.events.EventsUseCases
import pro.itshark.moneysplitter.model.repository.UserRepository
import pro.itshark.moneysplitter.model.repository.events.EventsRepository

@Module
class UseCasesModule {

    @Provides
    fun provideUserUseCases(userRepository: UserRepository): UserUseCases = UserInteractor(userRepository)

    @Provides
    fun provideEventUseCases(eventRepository: EventRepository): EventUseCases = EventInteractor(eventRepository)

    @Provides
    fun provideEventsUseCases(eventsRepository: EventsRepository) : EventsUseCases = EventsInteractor();
}
