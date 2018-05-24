package pro.itshark.moneysplitter.model.pojo

import com.google.gson.annotations.SerializedName

data class EventEntry(

    @SerializedName("Id")
    val id: Int,

    @SerializedName("DeadlineDate")
    val deadLineDate: String,

    @SerializedName("IsClosed")
    val isClosed: Boolean,

    @SerializedName("SingleCost")
    val singleCost: Double,

    @SerializedName("Title")
    val title: String,

    @SerializedName("Description")
    val description: String,

    @SerializedName("CreationDate")
    val creationDate: String,

    @SerializedName("Coast")
    val coast: Int,

    @SerializedName("OngoingDate")
    val ongoingDate: String,

    @SerializedName("ImageUrl")
    val imageUrl: String
)