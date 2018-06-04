package pro.itshark.moneysplitter.model.repository

import io.reactivex.Single
import pro.itshark.moneysplitter.model.pojo.UserEntry

interface UserRepository {
    fun getUserInfo(): Single<UserEntry>
    fun login(email: String, password: String) : Observable<UserEntry>
    fun register(userEntry: UserEntry) : Observable<UserEntry>
}
