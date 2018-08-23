package pro.itshark.moneysplitter.presentation.events.details

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import pro.itshark.moneysplitter.EVENT_ID
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.databinding.ActivityEventDetailsBinding
import javax.inject.Inject

class EventDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: EventDetailViewModel

    companion object {
        fun start(context: Context, id: Long) = context.startActivity(Intent(context, EventDetailActivity::class.java).putExtra(EVENT_ID, id))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(EventDetailViewModel::class.java)

        val eventId = intent.extras.getLong(EVENT_ID)
        viewModel.init(eventId)

        val binding = DataBindingUtil.setContentView<ActivityEventDetailsBinding>(this, R.layout.activity_event_details)
        binding.viewModel = viewModel

    }
}