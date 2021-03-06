package pro.itshark.moneysplitter.presentation.events

import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.common.RecyclerBaseAdapter

class EventsAdapter(var items: List<EventModel>, var listener: EventsClickListener) : RecyclerBaseAdapter() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.adapter_events_item

    override fun getViewModel(position: Int) = EventsItemViewModel(items[position], listener)

    override fun getItemCount() = items.size

    fun update(eventList : List<EventModel>) {
        items = eventList.toMutableList()
        notifyDataSetChanged()
    }

    interface EventsClickListener {
        fun onItemClicked(eventId: Long)
    }
}