package pro.itshark.moneysplitter.model.repository

import io.reactivex.Observable
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.presentation.newevent.Event

interface EventRepository {

    fun createEvent(event: Event, email: String, token: String): Observable<ResponseBody>
}