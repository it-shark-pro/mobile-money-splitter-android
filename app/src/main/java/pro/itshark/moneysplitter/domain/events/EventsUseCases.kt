package pro.itshark.moneysplitter.domain.events

import io.reactivex.Single
import pro.itshark.moneysplitter.presentation.newevent.EventModel

interface EventsUseCases {

    fun getEvents() : Single<List<EventModel>>
}