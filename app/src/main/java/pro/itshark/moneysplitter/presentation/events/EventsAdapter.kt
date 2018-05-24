package pro.itshark.moneysplitter.presentation.events

import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.common.RecyclerBaseAdapter
import pro.itshark.moneysplitter.presentation.newevent.EventModel

class EventsAdapter(var items: List<EventModel>) : RecyclerBaseAdapter() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.adapter_events_item

    override fun getViewModel(position: Int) = EventsItemViewModel(items[position].title)

    override fun getItemCount() = items.size

    fun update(eventList : List<EventModel>) {
        items = eventList.toMutableList()
        notifyDataSetChanged()
    }
}