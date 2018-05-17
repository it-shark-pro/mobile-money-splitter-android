package pro.itshark.moneysplitter.model.repository

import io.reactivex.Observable
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.pojo.User
import retrofit2.Response

class UserDownloader(private val api: Api): UserRepository {

    override fun login(user: User): Observable<Response<User>> {
        return api.login(user)
    }

    override fun register(user: User): Observable<Response<User>> {
        return api.register(user)
    }
}