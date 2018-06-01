package pro.itshark.moneysplitter.model.repository.events

import io.reactivex.Single
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.pojo.EventEntry
import pro.itshark.moneysplitter.model.pojo.NewEventEntry

class EventsRepositoryImpl(private val api: Api) : EventsRepository {

    override fun getEvents(): Single<List<EventEntry>> = api.getEvents()

    override fun createEvent(event: NewEventEntry, email: String, token: String): Single<ResponseBody> =
            api.createEvent(email, token, event)
}