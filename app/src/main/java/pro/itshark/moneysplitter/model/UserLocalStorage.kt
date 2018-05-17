package pro.itshark.moneysplitter.model

import android.content.Context
import io.reactivex.Single
import pro.itshark.moneysplitter.PreferenceKey
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.model.repository.UserRepository
import pro.itshark.moneysplitter.common.PreferenceHelper.defaultSharedPreferences
import pro.itshark.moneysplitter.common.PreferenceHelper.get

class UserLocalStorage(private val context: Context) : UserRepository {

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
