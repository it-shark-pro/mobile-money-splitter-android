package pro.itshark.moneysplitter.presentation.newevent

import android.databinding.BaseObservable
import android.databinding.Bindable
import pro.itshark.moneysplitter.BR

data class Event(
        private var _title: String = "",
        private var _description: String = "",
        private var _cost: String = ""
) : BaseObservable() {

    var title : String
    @Bindable get() = _title
    set(value) {
        _title = value
        notifyPropertyChanged(BR.title)
    }

    var description : String
    @Bindable get() = _description
    set(value) {
        _description = value
        notifyPropertyChanged(BR.description)
    }

    var cost : String
    @Bindable get() = _cost.toString()
    set(value) {
        _cost = value
        notifyPropertyChanged(BR.cost)
    }
}