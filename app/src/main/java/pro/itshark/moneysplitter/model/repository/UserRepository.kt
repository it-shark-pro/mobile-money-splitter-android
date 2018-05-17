package pro.itshark.moneysplitter.model.repository

import io.reactivex.Observable
import pro.itshark.moneysplitter.model.pojo.UserEntry
import retrofit2.Response

interface UserRepository {
    fun login(email: String, password: String) : Observable<UserEntry>
    fun register(userEntry: UserEntry) : Observable<UserEntry>
}