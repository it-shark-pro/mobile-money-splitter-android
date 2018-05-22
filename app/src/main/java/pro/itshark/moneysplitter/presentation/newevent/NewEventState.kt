package pro.itshark.moneysplitter.presentation.newevent

sealed class NewEventState {
    abstract val event: Event
}

data class DefaultState(override val event: Event) : NewEventState()
data class SendingState(override val event: Event) : NewEventState()
data class SuccessState(override val event: Event) : NewEventState()
data class ErrorState(override val event: Event, val ErrorMessage: String) : NewEventState()