package pro.itshark.moneysplitter.presentation.events

import android.arch.lifecycle.ViewModel
import pro.itshark.moneysplitter.domain.events.EventsUseCases
import javax.inject.Inject

class EventsViewModel
@Inject constructor(private val eventsUseCases: EventsUseCases) : ViewModel() {
}