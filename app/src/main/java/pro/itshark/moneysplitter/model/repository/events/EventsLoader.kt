package pro.itshark.moneysplitter.model.repository.events

import io.reactivex.Single
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.pojo.EventEntry

class EventsLoader(private val api: Api) : EventsRepository {

    override fun getEvents(): Single<List<EventEntry>> {
        /*val entryList = arrayListOf<EventEntry>()

        for(position in 1..5) {
            val entry = EventEntry(
                    0 + position,
                    "\\/Date(1526701292000)\\/",
                    false,
                    31,
                    "Бочка китайской капусты \"Чуан-хай\" для дяди Коли",
                    "Китайская капуста \"Чуан-хай\" состоит из 18 видов специй и капусты, дарит свежесть и ты чувствуешь себя человеком",
                    "/Date(1526647296000)/",
                    123,
                    "/Date(-62135596800000)/",
                    "http://moneytransfer.azurewebsites.net/Images?path=0-transaction.jpg"
            )

            entryList.add(entry)
        }

        return Single.just(entryList)*/
        return api.getEvents()
    }

}