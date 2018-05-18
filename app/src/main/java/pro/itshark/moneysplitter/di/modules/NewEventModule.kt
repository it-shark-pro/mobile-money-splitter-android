package pro.itshark.moneysplitter.di.modules

import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.domain.EventInteractor
import pro.itshark.moneysplitter.domain.EventUseCases
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.repository.EventCreator
import pro.itshark.moneysplitter.model.repository.EventRepository
import javax.inject.Singleton

@Module
class NewEventModule {

    @Provides
    @Singleton
    fun provideNewEventRepository(api: Api): EventRepository = EventCreator(api)

    @Provides
    fun provideEventUseCases(eventRepository: EventRepository): EventUseCases = EventInteractor(eventRepository)
}