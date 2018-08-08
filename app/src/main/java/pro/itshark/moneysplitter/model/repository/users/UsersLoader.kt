package pro.itshark.moneysplitter.model.repository.users

import android.content.Context
import io.reactivex.Observable
import io.reactivex.Single
import pro.itshark.moneysplitter.PreferenceKey
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.common.PreferenceHelper.defaultSharedPreferences
import pro.itshark.moneysplitter.common.PreferenceHelper.get
import pro.itshark.moneysplitter.common.PreferenceHelper.set
import pro.itshark.moneysplitter.model.api.Api

class UsersLoader(private val context: Context, private val api: Api) : UsersRepository {

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
        val preferences = defaultSharedPreferences(context)

        return Single.just(UserEntry(
                preferences[PreferenceKey.ID],
                preferences[PreferenceKey.EMAIL],
                preferences[PreferenceKey.NAME],
                preferences[PreferenceKey.SURNAME],
                preferences[PreferenceKey.PHONE_NUMBER],
                preferences[PreferenceKey.CREDIT_CARD_NUMBER],
                preferences[PreferenceKey.BALANCE],
                preferences[PreferenceKey.TOKEN],
                preferences[PreferenceKey.IMAGE_URL],
                preferences[PreferenceKey.BACKGROUND_IMAGE_URL]
        ))
    }

    override fun searchUsers(value: String): Observable<List<UserEntry>> = api.searchUsers(value)
}
