package pro.itshark.moneysplitter.presentation.regLogin.registration

import android.databinding.BaseObservable
import android.databinding.Bindable
import pro.itshark.moneysplitter.BR
import pro.itshark.moneysplitter.EMPTY_STRING

class RegistrationModel(name: String = EMPTY_STRING,
                        email: String = EMPTY_STRING,
                        password: String = EMPTY_STRING,
                        surname: String = EMPTY_STRING,
                        phoneNumber: String = EMPTY_STRING,
                        creditCardNumber: String = EMPTY_STRING): BaseObservable() {
    var name: String = name
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    var email: String = email
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    var password: String = password
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.password)
        }

    var surname: String = surname
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.surname)
        }

    var phoneNumber: String = phoneNumber
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.phoneNumber)
        }

    var creditCardNumber: String = creditCardNumber
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.creditCardNumber)
        }
}