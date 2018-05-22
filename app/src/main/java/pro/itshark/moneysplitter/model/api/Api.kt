package pro.itshark.moneysplitter.model.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.presentation.newevent.Event
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {

    @POST("transactions/add")
    fun createEvent(@Header("X-USERNAME") email: String,
                    @Header("X-TOKEN") token: String,
                    @Body event: Event): Observable<ResponseBody>

}