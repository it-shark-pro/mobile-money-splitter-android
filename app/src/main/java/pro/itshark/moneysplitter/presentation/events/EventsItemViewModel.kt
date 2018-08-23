package pro.itshark.moneysplitter.presentation.events

import android.arch.lifecycle.ViewModel

class EventsItemViewModel(var event: EventModel, var listener: EventsAdapter.EventsClickListener) : ViewModel() {

    fun openDetailActivity() {
        listener.onItemClicked(event.id)
    }
}