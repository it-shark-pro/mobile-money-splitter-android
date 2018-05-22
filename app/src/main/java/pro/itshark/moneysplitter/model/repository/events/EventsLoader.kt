package pro.itshark.moneysplitter.model.repository.events

import io.reactivex.Single
import pro.itshark.moneysplitter.model.pojo.EventEntry

class EventsLoader : EventsRepository {

    override fun getEvents(): Single<List<EventEntry>>? {
        return null;
    }

}