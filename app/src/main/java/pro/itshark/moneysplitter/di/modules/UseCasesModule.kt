package pro.itshark.moneysplitter.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.domain.events.EventsInteractor
import pro.itshark.moneysplitter.domain.events.EventsUseCases
import pro.itshark.moneysplitter.domain.UserInteractor
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.model.repository.events.EventsRepository
import pro.itshark.moneysplitter.model.repository.UserRepository

@Module
class UseCasesModule {

    @Provides
    fun provideUserUseCases(userRepository: UserRepository): UserUseCases = UserInteractor(userRepository)

    @Provides
    fun provideEventUseCases(eventRepository: EventsRepository, app: Application): EventsUseCases = EventsInteractor(eventRepository, app)
}
