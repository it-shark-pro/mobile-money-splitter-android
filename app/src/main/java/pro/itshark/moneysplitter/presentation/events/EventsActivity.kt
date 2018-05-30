package pro.itshark.moneysplitter.presentation.events

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_events.*
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.databinding.ActivityEventsBinding
import pro.itshark.moneysplitter.presentation.events.newevent.NewEventActivity
import pro.itshark.moneysplitter.presentation.userProfile.UserProfileActivity
import javax.inject.Inject


class EventsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: EventsViewModel

    private val adapter = EventsAdapter(listOf())

    private lateinit var eventsRecyclerView : RecyclerView

    private val stateViewModelObserver = Observer<EventsState> {state ->
        state?.let {
            when(state) {
                is SuccessState -> adapter.update(state.eventList)
                is ErrorState -> Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

        add_new_event_button.setOnClickListener { NewEventActivity.start(this) }

        button.setOnClickListener({ UserProfileActivity.start(this) })
    }

    private fun init() {
        AndroidInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(EventsViewModel::class.java)
        viewModel.stateViewModel.observe(this, stateViewModelObserver)

        val binding = DataBindingUtil.setContentView<ActivityEventsBinding>(this, R.layout.activity_events)
        binding.viewModel = viewModel

        eventsRecyclerView = events_recycler_view
        eventsRecyclerView.layoutManager = LinearLayoutManager(this)
        eventsRecyclerView.setHasFixedSize(true)
        eventsRecyclerView.adapter = adapter

        viewModel.loadEvents()
    }

    override fun onDestroy() {
        super.onDestroy()

        viewModel.stateViewModel.removeObserver(stateViewModelObserver)
    }
}
