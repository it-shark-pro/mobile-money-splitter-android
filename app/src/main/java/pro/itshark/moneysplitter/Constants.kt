package pro.itshark.moneysplitter

const val BASE_URL = "https://moneytransfer.azurewebsites.net/"
const val EVENT_ID = "event_id"

object Timeout {
    const val connect: Long = 30
    const val read: Long = 60
    const val write: Long = 60

    const val debounce: Long = 300
}

object PreferenceKey {
    const val ID = "id"
    const val NAME = "name"
    const val SURNAME = "surname"
    const val EMAIL = "email"
    const val PHONE_NUMBER = "phone number"
    const val CREDIT_CARD_NUMBER = "credit card number"
    const val BALANCE = "balance"
    const val TOKEN = "token"
    const val IMAGE_URL = "image_url"
    const val BACKGROUND_IMAGE_URL = "background image url"
}

object IntentKey {
    const val users = "users"
}

const val EMPTY_STRING = ""
const val ZERO_LONG = 0L
const val ZERO_FLOAT = 0f
