package pro.itshark.moneysplitter.model

import android.content.Context
import io.reactivex.Observable
import io.reactivex.Single
import pro.itshark.moneysplitter.PreferenceKey
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.model.repository.UserRepository
import pro.itshark.moneysplitter.common.PreferenceHelper.defaultSharedPreferences
import pro.itshark.moneysplitter.common.PreferenceHelper.get
import pro.itshark.moneysplitter.model.api.Api

class UserDownloader(private val context: Context, private val api: Api) : UserRepository {

    override fun login(email: String, password: String): Observable<UserEntry> {
        return api.login(email, password)
    }

    override fun register(userEntry: UserEntry): Observable<UserEntry> {
        return api.register(userEntry)
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
