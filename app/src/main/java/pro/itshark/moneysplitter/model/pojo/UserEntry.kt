package pro.itshark.moneysplitter.model.pojo

import com.google.gson.annotations.SerializedName
import pro.itshark.moneysplitter.EMPTY_STRING
import pro.itshark.moneysplitter.ZERO_LONG
import pro.itshark.moneysplitter.ZERO_FLOAT
import pro.itshark.moneysplitter.presentation.regLogin.registration.RegistrationModel

data class UserEntry(
        @SerializedName("Id") val id: Long = ZERO_LONG,
        @SerializedName("Email") val email: String = EMPTY_STRING,
        @SerializedName("UserName") val name: String = EMPTY_STRING,
        @SerializedName("Surname") val surname: String = EMPTY_STRING,
        @SerializedName("PhoneNumber") val phoneNumber: Long = ZERO_LONG,
        @SerializedName("CreditCardNumber") val creditCardNumber: Long = ZERO_LONG,
        @SerializedName("Ballance") val balance: Float = ZERO_FLOAT,
        @SerializedName("Token") val token: String = EMPTY_STRING,
        @SerializedName("ImageUrl") val imageUrl: String = EMPTY_STRING,
        @SerializedName("BackgroundImageUrl") val backgroundImageUrl: String = EMPTY_STRING,
        val password: String = EMPTY_STRING){

    companion object {

        fun create(userEntry: RegistrationModel): UserEntry {
            var phoneNumber = "0"
            if (userEntry.phoneNumber != EMPTY_STRING)
                phoneNumber = userEntry.phoneNumber

            var creditCardNumber = "0"
            if (userEntry.creditCardNumber != EMPTY_STRING)
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
