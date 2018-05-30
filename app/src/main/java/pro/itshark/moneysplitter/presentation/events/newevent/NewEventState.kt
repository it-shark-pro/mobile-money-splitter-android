package pro.itshark.moneysplitter.presentation.events.newevent

import pro.itshark.moneysplitter.presentation.events.EventModel

sealed class NewEventState {
    abstract val event: EventModel
}

data class DefaultState(override val event: EventModel) : NewEventState()
data class SendingState(override val event: EventModel) : NewEventState()
data class SuccessState(override val event: EventModel) : NewEventState()
data class ChoosingImageState(override val event: EventModel) : NewEventState()
data class ErrorState(override val event: EventModel, val ErrorMessage: String) : NewEventState()