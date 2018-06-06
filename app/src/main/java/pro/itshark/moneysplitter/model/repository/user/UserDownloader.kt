package pro.itshark.moneysplitter.model.repository.user

import android.content.Context
import io.reactivex.Observable
import io.reactivex.Single
import pro.itshark.moneysplitter.PreferenceKey
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.common.PreferenceHelper.defaultSharedPreferences
import pro.itshark.moneysplitter.common.PreferenceHelper.get
import pro.itshark.moneysplitter.common.PreferenceHelper.set
import pro.itshark.moneysplitter.model.api.Api

class UserDownloader(private val context: Context, private val api: Api) : UserRepository {

    override fun login(userEntry: UserEntry): Single<UserEntry> {
        return api.login(userEntry)
    }

    override fun register(userEntry: UserEntry): Single<UserEntry> {
        return api.register(userEntry)
    }

    override fun saveUserInfo(userEntry: UserEntry) {
        val preferences = defaultSharedPreferences(context)
        preferences[PreferenceKey.ID] = userEntry.id
        preferences[PreferenceKey.EMAIL] = userEntry.email
        preferences[PreferenceKey.NAME] = userEntry.name
        preferences[PreferenceKey.SURNAME] = userEntry.surname
        preferences[PreferenceKey.PHONE_NUMBER] = userEntry.phoneNumber
        preferences[PreferenceKey.CREDIT_CARD_NUMBER] = userEntry.creditCardNumber
        preferences[PreferenceKey.BALANCE] = userEntry.balance
        preferences[PreferenceKey.TOKEN] = userEntry.token
        preferences[PreferenceKey.IMAGE_URL] = userEntry.imageUrl
        preferences[PreferenceKey.BACKGROUND_IMAGE_URL] = userEntry.backgroundImageUrl
    }

    override fun loadUserToken(): String {
        val preferences = defaultSharedPreferences(context)
        return preferences[PreferenceKey.TOKEN]
    }

    override fun getUserInfo(): Single<UserEntry> {
        val prefs = defaultSharedPreferences(context)

        return Single.just(UserEntry(
                prefs[PreferenceKey.ID],
                prefs[PreferenceKey.EMAIL],
                prefs[PreferenceKey.NAME],
                prefs[PreferenceKey.SURNAME],
                prefs[PreferenceKey.PHONE_NUMBER],
                prefs[PreferenceKey.CREDIT_CARD_NUMBER],
                prefs[PreferenceKey.BALANCE],
                prefs[PreferenceKey.TOKEN],
                prefs[PreferenceKey.IMAGE_URL],
                prefs[PreferenceKey.BACKGROUND_IMAGE_URL]
        ))
    }
}
