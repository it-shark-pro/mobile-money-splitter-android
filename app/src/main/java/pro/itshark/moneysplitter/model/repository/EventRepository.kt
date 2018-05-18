package pro.itshark.moneysplitter.model.repository

import io.reactivex.Observable
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.model.pojo.Event

interface EventRepository {

    fun createEvent(event: Event, email: String, token: String): Observable<ResponseBody>
}