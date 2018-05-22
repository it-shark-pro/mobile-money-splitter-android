package pro.itshark.moneysplitter.domain

import io.reactivex.Observable
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.presentation.newevent.Event

interface EventUseCases {

    fun createEvent(event: Event, email: String, token: String): Observable<ResponseBody>
}