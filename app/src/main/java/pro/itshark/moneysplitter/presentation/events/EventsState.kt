package pro.itshark.moneysplitter.presentation.events

import pro.itshark.moneysplitter.presentation.newevent.EventModel

sealed class EventsState {
    abstract val eventList: List<EventModel>
}

data class DefaultState(override val eventList: List<EventModel>) : EventsState()
data class LoadingState(override val eventList: List<EventModel>) : EventsState()
data class SuccessState(override val eventList: List<EventModel>) : EventsState()
data class ErrorState(override val eventList: List<EventModel>, val ErrorMessage: String) : EventsState()
