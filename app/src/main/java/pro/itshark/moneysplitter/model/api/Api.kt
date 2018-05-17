package pro.itshark.moneysplitter.model.api

import io.reactivex.Observable
import pro.itshark.moneysplitter.model.pojo.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("session/register")
    fun register(@Body user: User): Observable<Response<User>>

    @POST("session/signin")
    fun login(@Body user: User): Observable<Response<User>>
}