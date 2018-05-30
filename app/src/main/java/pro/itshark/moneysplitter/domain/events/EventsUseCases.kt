package pro.itshark.moneysplitter.domain.events

import io.reactivex.Single
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.presentation.events.EventModel

interface EventsUseCases {

    fun createEvent(event: EventModel, email: String, token: String): Single<ResponseBody>

    fun getEvents() : Single<List<EventModel>>
}