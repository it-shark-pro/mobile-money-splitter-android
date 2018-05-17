package pro.itshark.moneysplitter.model.repository

import io.reactivex.Observable
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.pojo.UserEntry
import retrofit2.Response

class UserDownloader(private val api: Api): UserRepository {

    override fun login(email: String, password: String): Observable<UserEntry> {
        return api.login(email, password)
    }

    override fun register(userEntry: UserEntry): Observable<UserEntry> {
        return api.register(userEntry)
    }
}