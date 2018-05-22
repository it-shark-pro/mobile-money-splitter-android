package pro.itshark.moneysplitter.presentation.newevent

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import dagger.android.AndroidInjection
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.databinding.ActivityAddEventBinding
import javax.inject.Inject

class NewEventActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) = context.startActivity(Intent(context, NewEventActivity::class.java))
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var dialog: AlertDialog

    private lateinit var viewModel: NewEventViewModel

    private val stateObserver = Observer<NewEventState> { state ->
        state?.let {
            when (state) {
                is DefaultState -> {
                    dialog.dismiss()
                }
                is SendingState -> {
                    dialog.show()
                }
                is SuccessState -> {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    finish()
                }
                is ErrorState -> {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        AndroidInjection.inject(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        title = getString(R.string.new_event)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewEventViewModel::class.java)
        viewModel.stateLiveData.observe(this, stateObserver)

        val binding = DataBindingUtil.setContentView<ActivityAddEventBinding>(this, R.layout.activity_add_event)
        binding.viewModel = viewModel

        dialog = createDialog()
    }

    private fun createDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        builder.setView(View.inflate(this, R.layout.progress_dialog, null))
        builder.setCancelable(false)
        return builder.create()
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
}