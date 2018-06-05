package pro.itshark.moneysplitter.model.pojo

import com.google.gson.annotations.SerializedName
import pro.itshark.moneysplitter.EMPTY_STRING
import pro.itshark.moneysplitter.presentation.regLogin.registration.RegistrationModel

data class UserEntry(
        @SerializedName("Id") val id: Long = 0L,
        @SerializedName("Email") val email: String = "",
        @SerializedName("UserName") val name: String = "",
        @SerializedName("Surname") val surname: String = "",
        @SerializedName("PhoneNumber") val phoneNumber: Long = 0L,
        @SerializedName("CreditCardNumber") val creditCardNumber: Long = 0L,
        @SerializedName("Ballance") val balance: Float = 0f,
        @SerializedName("Token") val token: String = "",
        @SerializedName("ImageUrl") val imageUrl: String = "",
        @SerializedName("BackgroundImageUrl") val backgroundImageUrl: String = "",
        val password: String = EMPTY_STRING){

    companion object {

        fun create(userEntry: RegistrationModel): UserEntry {
            var phoneNumber: String = "0"
            if (userEntry.phoneNumber != "")
                phoneNumber = userEntry.phoneNumber

            var creditCardNumber: String = "0"
            if (userEntry.creditCardNumber != "")
                creditCardNumber = userEntry.creditCardNumber

            return UserEntry(email = userEntry.email,
                    name = userEntry.name,
                    surname = userEntry.surname,
                    phoneNumber = phoneNumber.toLong(),
                    creditCardNumber = creditCardNumber.toLong(),
                    password = userEntry.password)
        }
    }
}
