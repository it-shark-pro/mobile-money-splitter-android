package pro.itshark.moneysplitter.model.pojo

import com.google.gson.annotations.SerializedName

data class NewEventEntry(
        @SerializedName("Title") val title: String,
        @SerializedName("Description") val description: String,
        @SerializedName("Coast") val cost: Double,
        @SerializedName("ImageBase64String") val image: String
)