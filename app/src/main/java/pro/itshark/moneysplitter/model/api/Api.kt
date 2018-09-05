package pro.itshark.moneysplitter.model.api

import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.model.pojo.EventEntry
import pro.itshark.moneysplitter.model.pojo.NewEventEntry
import pro.itshark.moneysplitter.model.pojo.UserEntry
import retrofit2.http.*

interface Api {

    @POST("session/register")
    fun register(@Body userEntry: UserEntry): Single<UserEntry>

    @POST("session/signin")
    fun login(@Body userEntry: UserEntry): Single<UserEntry>

    @GET("transactions/all")
    fun getEvents(): Single<List<EventEntry>>

    @POST("transactions/add")
    fun createEvent(@Header("X-USERNAME") email: String,
                    @Header("X-TOKEN") token: String,
                    @Body event: NewEventEntry): Single<ResponseBody>

    @GET("users/search")
    fun searchUsers(@Query("query") value: String): Observable<List<UserEntry>>

    @POST("friends/add")
    fun addFriend(@Header("X-USERNAME") email: String,
                  @Header("X-TOKEN") token: String,
                  @Query("friendId") id: Int): Single<ResponseBody>

    @POST("friends/remove")
    fun removeFriend(@Header("X-USERNAME") email: String,
                     @Header("X-TOKEN") token: String,
                     @Query("friendId") id: Int): Single<ResponseBody>

    @GET("friends/all")
    fun getAllFriends(@Header("X-USERNAME") email: String,
                      @Header("X-TOKEN") token: String): Observable<List<UserEntry>>
}
