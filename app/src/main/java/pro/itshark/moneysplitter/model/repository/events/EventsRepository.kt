package pro.itshark.moneysplitter.model.repository.events

import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.model.pojo.EventEntry
import pro.itshark.moneysplitter.model.pojo.NewEventEntry

interface EventsRepository {

    fun createEvent(event: NewEventEntry, email: String, token: String): Observable<ResponseBody>

    fun getEvents() : Single<List<EventEntry>>
}