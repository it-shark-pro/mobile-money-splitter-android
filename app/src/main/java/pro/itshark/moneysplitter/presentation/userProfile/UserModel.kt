package pro.itshark.moneysplitter.presentation.userProfile

import android.databinding.BaseObservable
import android.databinding.Bindable
import pro.itshark.moneysplitter.BR
import pro.itshark.moneysplitter.EMPTY_STRING

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

    var imageUrl: String = imageUrl
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.imageUrl)
        }

    fun update(userModel: UserModel) {
        name = userModel.name
        surname = userModel.surname
        imageUrl = userModel.imageUrl
    }
}
