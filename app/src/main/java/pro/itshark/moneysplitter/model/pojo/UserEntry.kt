package pro.itshark.moneysplitter.model.pojo

import com.google.gson.annotations.SerializedName
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

data class UserEntry(
        @SerializedName("Id") val id: Long,
        @SerializedName("Email") val email: String,
        @SerializedName("UserName") val name: String,
        @SerializedName("Surname") val surname: String,
        @SerializedName("PhoneNumber") val phoneNumber: Long,
        @SerializedName("CreditCardNumber") val creditCardNumber: Long,
        @SerializedName("Ballance") val balance: Float,
        @SerializedName("Token") val token: String,
        @SerializedName("ImageUrl") val imageUrl: String,
        @SerializedName("BackgroundImageUrl") val backgroundImageUrl: String
) {
    fun convertToModel(): UserModel =
            UserModel(id, email, name, surname, phoneNumber, creditCardNumber, balance, token, imageUrl, backgroundImageUrl)
}
