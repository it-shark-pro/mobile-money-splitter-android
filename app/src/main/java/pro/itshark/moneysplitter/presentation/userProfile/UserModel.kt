package pro.itshark.moneysplitter.presentation.userProfile

import android.databinding.BaseObservable
import android.databinding.Bindable
import pro.itshark.moneysplitter.BR
import pro.itshark.moneysplitter.EMPTY_STRING
import pro.itshark.moneysplitter.model.pojo.UserEntry

class UserModel(
        var id: Long = 0,
        email: String = EMPTY_STRING,
        name: String = EMPTY_STRING,
        surname: String = EMPTY_STRING,
        phoneNumber: Long = 0,
        creditCardNumber: Long = 0,
        balance: Float = 0F,
        token: String = EMPTY_STRING,
        imageUrl: String = EMPTY_STRING,
        backgroundImageUrl: String = EMPTY_STRING
) : BaseObservable() {

    companion object {
        fun create(userEntry: UserEntry): UserModel = UserModel(
                userEntry.id,
                userEntry.email,
                userEntry.name,
                userEntry.surname,
                userEntry.phoneNumber,
                userEntry.creditCardNumber,
                userEntry.balance,
                userEntry.token,
                userEntry.imageUrl,
                userEntry.backgroundImageUrl
        )
    }

    var email: String = email
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    var name: String = name
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    var surname: String = surname
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.surname)
        }

    var phoneNumber: Long = phoneNumber
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.phoneNumber)
        }

    var creditCardNumber: Long = creditCardNumber
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.creditCardNumber)
        }

    var balance: Float = balance
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.balance)
        }

    var token: String = token
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.token)
        }

    var imageUrl: String = imageUrl
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.imageUrl)
        }

    var backgroundImageUrl: String = backgroundImageUrl
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.backgroundImageUrl)
        }

    fun update(userModel: UserModel) {
        email = userModel.email
        name = userModel.name
        surname = userModel.surname
        phoneNumber = userModel.phoneNumber
        creditCardNumber = userModel.creditCardNumber
        balance = userModel.balance
        token = userModel.token
        imageUrl = userModel.imageUrl
        backgroundImageUrl = userModel.backgroundImageUrl
    }
}
