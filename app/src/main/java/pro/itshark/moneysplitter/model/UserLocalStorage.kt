package pro.itshark.moneysplitter.model

import android.content.Context
import io.reactivex.Single
import pro.itshark.moneysplitter.PrefKey
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.model.repository.UserRepository
import pro.itshark.moneysplitter.utility.PreferenceHelper.defaultSharedPreferences
import pro.itshark.moneysplitter.utility.PreferenceHelper.get

class UserLocalStorage(private val context: Context) : UserRepository {

    override fun getUserInfo(): Single<UserEntry> {
        val prefs = defaultSharedPreferences(context)

        return Single.just(UserEntry(
                prefs[PrefKey.ID],
                prefs[PrefKey.EMAIL],
                prefs[PrefKey.NAME],
                prefs[PrefKey.SURNAME],
                prefs[PrefKey.PHONE_NUMBER],
                prefs[PrefKey.CREDIT_CARD_NUMBER],
                prefs[PrefKey.BALANCE],
                prefs[PrefKey.TOKEN],
                prefs[PrefKey.IMAGE_URL],
                prefs[PrefKey.BACKGROUND_IMAGE_URL],
                prefs[PrefKey.FRIENDS]
        ))
    }
}
