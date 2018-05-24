package pro.itshark.moneysplitter.model.api

import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.model.pojo.EventEntry
import pro.itshark.moneysplitter.presentation.newevent.EventModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {

    @GET("transactions/all")
    fun getEvents() : Single<List<EventEntry>>

    @POST("transactions/add")
    fun createEvent(@Header("X-USERNAME") email: String,
                    @Header("X-TOKEN") token: String,
                    @Body event: EventModel): Observable<ResponseBody>

}