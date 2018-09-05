package pro.itshark.moneysplitter.model.pojo

import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique

@Entity
data class EventEntry(

        @Id(assignable = true)
        var dbId: Long = 0,

        @SerializedName("Id")
        @Unique
        var id: Long,

        @SerializedName("DeadlineDate")
        val deadLineDate: String?,

        @SerializedName("IsClosed")
        val isClosed: Boolean?,

        @SerializedName("SingleCost")
        val singleCost: Double?,

        @SerializedName("Title")
        val title: String?,

        @SerializedName("Description")
        val description: String?,

        @SerializedName("CreationDate")
        val creationDate: String?,

        @SerializedName("Coast")
        val coast: Int?,

        @SerializedName("OngoingDate")
        val ongoingDate: String?,

        @SerializedName("ImageUrl")
        val imageUrl: String?
)