package pro.itshark.moneysplitter.presentation.events

import android.databinding.BaseObservable
import android.databinding.Bindable
import pro.itshark.moneysplitter.BR
import pro.itshark.moneysplitter.EMPTY_STRING
import pro.itshark.moneysplitter.model.pojo.EventEntry

class EventModel(
        id: Long = 0,
        title: String = EMPTY_STRING,
        description: String = EMPTY_STRING,
        cost: String = EMPTY_STRING,
        image: String = EMPTY_STRING
) : BaseObservable() {

    companion object {
        fun create(eventEntry: EventEntry): EventModel = EventModel(
                eventEntry.id,
                eventEntry.title!!,
                eventEntry.description!!,
                eventEntry.coast.toString(),
                eventEntry.imageUrl!!
        )
    }

    var id: Long = id
    @Bindable get() = field
    set(value) {
        field = value
        notifyPropertyChanged(BR.id)
    }

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

    var image : String = image
    @Bindable get() = field
    set(value) {
        field = value
        notifyPropertyChanged(BR.image)
    }

}