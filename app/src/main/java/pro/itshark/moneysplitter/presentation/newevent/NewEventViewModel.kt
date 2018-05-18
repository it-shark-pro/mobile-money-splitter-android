package pro.itshark.moneysplitter.presentation.newevent

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.domain.EventUseCases
import pro.itshark.moneysplitter.model.pojo.Event
import javax.inject.Inject

class NewEventViewModel
@Inject constructor(private val eventUseCases: EventUseCases) : ViewModel() {

    val stateLiveData = MutableLiveData<NewEventState>()
    val title = ObservableField<String>()
    val description = ObservableField<String>()
    val cost = ObservableField<String>()

    private val event = Event()

    init {
        stateLiveData.value = DefaultState(event)
    }

    fun createButtonClicked() {
        stateLiveData.value = SendingState(event)
        event.title = title.get()!!
        event.description = description.get()!!
        event.cost = cost.get()!!.toDouble()
        eventUseCases.createEvent(event, "email", "token")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoadingSuccess, this::onLoadingFailure)
    }

    private fun onLoadingSuccess(body: ResponseBody) {
        stateLiveData.value = SuccessState(event)
    }

    private fun onLoadingFailure(e: Throwable) {
        Log.e("Sending error", e.toString())
        stateLiveData.value = ErrorState(event, e.toString())
    }
}