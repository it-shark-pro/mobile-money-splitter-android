package pro.itshark.moneysplitter.presentation.events.details

import android.arch.lifecycle.ViewModel
import pro.itshark.moneysplitter.domain.events.EventsUseCases
import pro.itshark.moneysplitter.presentation.events.EventModel
import javax.inject.Inject

class EventDetailViewModel
@Inject constructor(private val eventsUseCases: EventsUseCases): ViewModel() {

    lateinit var event: EventModel

    fun init(eventId: Long) {
        event = eventsUseCases.getEvent(eventId) }
}