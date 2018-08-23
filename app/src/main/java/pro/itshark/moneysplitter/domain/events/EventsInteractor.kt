package pro.itshark.moneysplitter.domain.events

import android.app.Application
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore.Images.Media
import android.util.Base64
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import io.objectbox.kotlin.query
import io.reactivex.Single
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.App
import pro.itshark.moneysplitter.model.pojo.EventEntry
import pro.itshark.moneysplitter.model.pojo.EventEntry_
import pro.itshark.moneysplitter.model.pojo.NewEventEntry
import pro.itshark.moneysplitter.model.repository.events.EventsRepository
import pro.itshark.moneysplitter.presentation.events.EventModel
import java.io.ByteArrayOutputStream
import javax.inject.Inject

class EventsInteractor(private val eventRepository: EventsRepository, private val app: Application) : EventsUseCases {

    @Inject
    lateinit var boxStore: BoxStore

    private val box: Box<EventEntry>

    init {
        App.component.inject(this)

        box = boxStore.boxFor()
    }

    override fun getEvents(): Single<List<EventModel>> =
            eventRepository.getEvents()
                    .toObservable()
                    .flatMapIterable { saveEvents(it) }
                    .map { entry -> EventModel.create(entry) }
                    .toList()

    override fun getEvent(eventId: Long): EventModel {
        val query = box.query {
            equal(EventEntry_.id, eventId)
        }

        val event = query.findFirst()

        return EventModel.create(event!!)
    }

    private fun saveEvents(events: List<EventEntry>): List<EventEntry> {
        for (event in events) {
            val query = box.query {
                equal(EventEntry_.id, event.id)
            }

            val item = query.findFirst()
            event.dbId = item?.dbId ?: 0

            box.put(event)
        }

        return events
    }

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