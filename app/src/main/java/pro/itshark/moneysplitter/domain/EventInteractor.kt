package pro.itshark.moneysplitter.domain

import io.reactivex.Observable
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.presentation.newevent.EventModel
import pro.itshark.moneysplitter.model.repository.EventRepository

class EventInteractor(private val eventRepository: EventRepository) : EventUseCases {

    override fun createEvent(event: EventModel, email: String, token: String): Observable<ResponseBody> =
            eventRepository.createEvent(event, email, token)
}