package pro.itshark.moneysplitter.model.repository

import io.reactivex.Observable
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.presentation.newevent.EventModel

class EventCreator(private val api: Api) : EventRepository {

    override fun createEvent(event: EventModel, email: String, token: String): Observable<ResponseBody> =
            api.createEvent(email, token, event)
}