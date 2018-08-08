package pro.itshark.moneysplitter.presentation.events.newevent

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.net.Uri
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.domain.events.EventsUseCases
import pro.itshark.moneysplitter.presentation.events.EventModel
import javax.inject.Inject

class NewEventViewModel
@Inject constructor(private val eventsUseCases: EventsUseCases) : ViewModel() {

    val stateLiveData = MutableLiveData<NewEventState>()

    val event = EventModel()

    init {
        stateLiveData.value = DefaultState(event)
    }

    fun createButtonClicked() {
        stateLiveData.value = SendingState(event)
        eventsUseCases.createEvent(event, "sasuke_kill_konoha@yandex.ru", "7f66310c-9aa4-44aa-9d03-98bd9ad4c4d4")
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

    fun addUsersButtonClicked() {
        stateLiveData.value = AdditionState(event)
    }

    fun onChooseImageClicked() {
        stateLiveData.value = ChoosingImageState(event)
    }

    fun onChoosingImageResult(uri: Uri) {
        stateLiveData.value = DefaultState(event)
        event.image = uri.toString()
    }
}