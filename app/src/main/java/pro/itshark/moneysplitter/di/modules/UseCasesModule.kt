package pro.itshark.moneysplitter.di.modules

import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.domain.EventInteractor
import pro.itshark.moneysplitter.domain.EventUseCases
import pro.itshark.moneysplitter.domain.UserInteractor
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.model.repository.EventRepository
import pro.itshark.moneysplitter.model.repository.UserRepository

@Module
class UseCasesModule {

    @Provides
    fun provideUserUseCases(userRepository: UserRepository): UserUseCases = UserInteractor(userRepository)

    @Provides
    fun provideEventUseCases(eventRepository: EventRepository): EventUseCases = EventInteractor(eventRepository)
}
