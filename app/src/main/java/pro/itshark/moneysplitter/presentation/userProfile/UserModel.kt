package pro.itshark.moneysplitter.presentation.userProfile

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import pro.itshark.moneysplitter.BR
import pro.itshark.moneysplitter.EMPTY_STRING
import pro.itshark.moneysplitter.ZERO_FLOAT
import pro.itshark.moneysplitter.ZERO_LONG
import pro.itshark.moneysplitter.model.pojo.UserEntry

@Parcelize
class UserModel(
        private val _id: Long = ZERO_LONG,
        private var _email: String = EMPTY_STRING,
        private var _name: String = EMPTY_STRING,
        private var _surname: String = EMPTY_STRING,
        private var _phoneNumber: Long = ZERO_LONG,
        private var _creditCardNumber: Long = ZERO_LONG,
        private var _balance: Float = ZERO_FLOAT,
        private var _token: String = EMPTY_STRING,
        private var _imageUrl: String = EMPTY_STRING,
        private var _backgroundImageUrl: String = EMPTY_STRING
) : BaseObservable(),
        Parcelable {
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

    val id: Long
        get() = _id

    var email: String
        @Bindable get() = _email
        set(value) {
            _email = value
            notifyPropertyChanged(BR.email)
        }

    var name: String
        @Bindable get() = _name
        set(value) {
            _name = value
            notifyPropertyChanged(BR.name)
        }

    var surname: String
        @Bindable get() = _surname
        set(value) {
            _surname = value
            notifyPropertyChanged(BR.surname)
        }

    var phoneNumber: Long
        @Bindable get() = _phoneNumber
        set(value) {
            _phoneNumber = value
            notifyPropertyChanged(BR.phoneNumber)
        }

    var creditCardNumber: Long
        @Bindable get() = _creditCardNumber
        set(value) {
            _creditCardNumber = value
            notifyPropertyChanged(BR.creditCardNumber)
        }

    var balance: Float
        @Bindable get() = _balance
        set(value) {
            _balance = value
            notifyPropertyChanged(BR.balance)
        }

    var token: String
        @Bindable get() = _token
        set(value) {
            _token = value
            notifyPropertyChanged(BR.token)
        }

    var imageUrl: String
        @Bindable get() = _imageUrl
        set(value) {
            _imageUrl = value
            notifyPropertyChanged(BR.imageUrl)
        }

    var backgroundImageUrl: String
        @Bindable get() = _backgroundImageUrl
        set(value) {
            _backgroundImageUrl = value
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
