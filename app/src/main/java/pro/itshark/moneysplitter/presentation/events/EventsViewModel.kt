package pro.itshark.moneysplitter.presentation.events

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.itshark.moneysplitter.domain.events.EventsUseCases
import pro.itshark.moneysplitter.presentation.newevent.EventModel
import javax.inject.Inject

class EventsViewModel
@Inject constructor(private val eventsUseCases: EventsUseCases) : ViewModel() {

    val stateViewModel = MutableLiveData<EventsState>()
    var eventList = listOf<EventModel>()

    init {
        stateViewModel.value = DefaultState(eventList)
    }

    fun loadEvents() {
        stateViewModel.value = LoadingState(eventList)

        eventsUseCases.getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::loadSuccess, this::loadError)
    }

    private fun loadSuccess(eventList : List<EventModel>) {
        stateViewModel.value = SuccessState(eventList)
        this.eventList = eventList
    }

    private fun loadError(e: Throwable) {
        stateViewModel.value = ErrorState(eventList, e.toString())
    }
}