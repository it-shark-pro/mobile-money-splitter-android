package pro.itshark.moneysplitter.model.pojo

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("Password") val password : String?,
        @SerializedName("ImageBase64String") val image: String,
        @SerializedName("BackgroundImageBase64String") val background: String,
        @SerializedName("Email") val email: String,
        @SerializedName("UserName") val userName: String,
        @SerializedName("Surname") val surname: String,
        @SerializedName("PhoneNumber") val phoneNumber: Long,
        @SerializedName("CreditCardNumber") val creditCardNumber: Long,
        @SerializedName("Token") val token: String?) {

    constructor(password: String = "", email: String = "") : this(password, "", "", email, "", "", 0, 0, "")
}

