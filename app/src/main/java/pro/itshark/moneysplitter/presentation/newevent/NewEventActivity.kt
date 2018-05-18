package pro.itshark.moneysplitter.presentation.newevent

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import dagger.android.AndroidInjection
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.databinding.ActivityAddEventBinding
import javax.inject.Inject

class NewEventActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: NewEventViewModel

    private val stateObserver = Observer<NewEventState> { state ->
        state?.let {
            when (state) {
                is DefaultState -> {
                    Log.d("State", "default state")
                }
                is SendingState -> {
                    Log.d("State", "sending state")
                }
                is SuccessState -> {
                    Log.d("State", "success state")
                }
                is ErrorState -> {
                    Log.d("State", "error state")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

        val binding = DataBindingUtil.setContentView<ActivityAddEventBinding>(this, R.layout.activity_add_event)
        binding.viewModel = viewModel
    }

    private fun init() {
        AndroidInjection.inject(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        title = getString(R.string.new_event)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewEventViewModel::class.java)
        viewModel.stateLiveData.observe(this, stateObserver)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()

        viewModel.stateLiveData.removeObserver(stateObserver)
    }

    companion object {
        fun start(context: Context) = context.startActivity(Intent(context, NewEventActivity::class.java))
    }
}