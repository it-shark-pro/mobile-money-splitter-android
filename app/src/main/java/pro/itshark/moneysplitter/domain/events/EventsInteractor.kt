package pro.itshark.moneysplitter.domain.events

import io.reactivex.Single
import pro.itshark.moneysplitter.model.repository.events.EventsRepository
import pro.itshark.moneysplitter.presentation.newevent.EventModel

class EventsInteractor(private val eventsRepository: EventsRepository) : EventsUseCases {

    override fun getEvents(): Single<List<EventModel>> =
            eventsRepository.getEvents()
                    .toObservable()
                    .flatMapIterable { it }
                    .map { entry -> EventModel.create(entry) }
                    .toList();
}