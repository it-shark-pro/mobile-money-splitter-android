package pro.itshark.moneysplitter.domain

import io.reactivex.Observable
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.presentation.newevent.EventModel

interface EventUseCases {

    fun createEvent(event: EventModel, email: String, token: String): Observable<ResponseBody>
}