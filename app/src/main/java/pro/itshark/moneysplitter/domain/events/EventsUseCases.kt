package pro.itshark.moneysplitter.domain.events

import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.presentation.events.EventModel

interface EventsUseCases {

    fun createEvent(event: EventModel, email: String, token: String): Observable<ResponseBody>

    fun getEvents() : Single<List<EventModel>>
}