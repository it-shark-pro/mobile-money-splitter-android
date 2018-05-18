package pro.itshark.moneysplitter.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_events.*
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.presentation.newevent.NewEventActivity

class EventsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        add_new_event_button.setOnClickListener { NewEventActivity.start(this) }
    }
}
