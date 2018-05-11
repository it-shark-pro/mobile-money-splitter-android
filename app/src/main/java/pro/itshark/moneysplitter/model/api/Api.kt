package pro.itshark.moneysplitter.model.api

import io.reactivex.Observable
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("session/register")
    fun register(
            @Field("Password") password: String,
            @Field("ImageBase64String") encodedImage: String,
            @Field("BackgroundImageBase64String") endocedBackgroundImage: String,
            @Field("Email") email: String,
            @Field("UserName") userName: String,
            @Field("Surname") surname: String,
            @Field("PhoneNumber") phoneNumber: String,
            @Field("CreditCardNumber") creditCardNumber: String) : Observable<ResponseBody>
}