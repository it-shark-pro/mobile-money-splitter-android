package pro.itshark.moneysplitter.presentation.newevent

import android.databinding.BaseObservable
import android.databinding.Bindable
import pro.itshark.moneysplitter.BR
import pro.itshark.moneysplitter.EMPTY_STRING

class EventModel(
        title: String = EMPTY_STRING,
        description: String = EMPTY_STRING,
        cost: String = EMPTY_STRING
) : BaseObservable() {

    var title: String = title
    @Bindable get() = field
    set(value) {
        field = value
        notifyPropertyChanged(BR.title)
    }

    var description : String = description
    @Bindable get() = field
    set(value) {
        field = value
        notifyPropertyChanged(BR.description)
    }

    var cost : String = cost
    @Bindable get() = field
    set(value) {
        field = value
        notifyPropertyChanged(BR.cost)
    }
}