package pro.itshark.moneysplitter.presentation.regLogin.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import pro.itshark.moneysplitter.BR
import pro.itshark.moneysplitter.EMPTY_STRING

class LoginModel(email: String = EMPTY_STRING,
                 password: String = EMPTY_STRING): BaseObservable() {

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
}