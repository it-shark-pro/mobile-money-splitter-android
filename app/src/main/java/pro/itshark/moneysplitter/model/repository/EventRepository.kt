package pro.itshark.moneysplitter.model.repository

import io.reactivex.Observable
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.presentation.newevent.EventModel

interface EventRepository {

    fun createEvent(event: EventModel, email: String, token: String): Observable<ResponseBody>
}