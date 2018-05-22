package pro.itshark.moneysplitter.presentation.newevent

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.domain.EventUseCases
import javax.inject.Inject

class NewEventViewModel
@Inject constructor(private val eventUseCases: EventUseCases) : ViewModel() {

    val stateLiveData = MutableLiveData<NewEventState>()

    val event = EventModel()

    init {
        stateLiveData.value = DefaultState(event)
    }

    fun createButtonClicked() {
        stateLiveData.value = SendingState(event)
        eventUseCases.createEvent(event, "sasuke_kill_konoha@yandex.ru", "5e910303-8a9b-41c1-b409-7bd809315a19")
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