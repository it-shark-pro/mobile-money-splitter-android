package pro.itshark.moneysplitter.model.repository.events

import io.reactivex.Single
import pro.itshark.moneysplitter.model.pojo.EventEntry

interface EventsRepository {

    fun getEvents() : Single<List<EventEntry>>?
}