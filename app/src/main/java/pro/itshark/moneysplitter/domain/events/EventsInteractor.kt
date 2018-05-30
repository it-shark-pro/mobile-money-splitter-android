package pro.itshark.moneysplitter.domain.events

import android.app.Application
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore.Images.Media
import android.util.Base64
import io.reactivex.Single
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.model.pojo.NewEventEntry
import pro.itshark.moneysplitter.model.repository.events.EventsRepository
import pro.itshark.moneysplitter.presentation.events.EventModel
import java.io.ByteArrayOutputStream

class EventsInteractor(private val eventRepository: EventsRepository, private val app: Application) : EventsUseCases {

    override fun getEvents(): Single<List<EventModel>> =
            eventRepository.getEvents()
                    .toObservable()
                    .flatMapIterable { it }
                    .map { entry -> EventModel.create(entry) }
                    .toList()

    override fun createEvent(event: EventModel, email: String, token: String): Single<ResponseBody> =
            eventRepository.createEvent(convertModel(event), email, token)

    private fun convertModel(eventModel: EventModel) = NewEventEntry(
                eventModel.title,
                eventModel.description,
                eventModel.cost.toDouble(),
                convertImage(eventModel.image))

    private fun convertImage(uri: String): String {
        val imageBitmap = Media.getBitmap(app.contentResolver, Uri.parse(uri))
        val byteArrayOutputStream = ByteArrayOutputStream()
        imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val imageByteArray = byteArrayOutputStream.toByteArray()

        return Base64.encodeToString(imageByteArray, Base64.DEFAULT)
    }
}