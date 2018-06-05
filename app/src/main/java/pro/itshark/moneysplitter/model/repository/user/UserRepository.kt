package pro.itshark.moneysplitter.model.repository.user

import io.reactivex.Observable
import io.reactivex.Single
import pro.itshark.moneysplitter.model.pojo.UserEntry

interface UserRepository {
    fun saveUserInfo(userEntry: UserEntry)
    fun getUserInfo(): Single<UserEntry>
    fun login(userEntry: UserEntry) : Observable<UserEntry>
    fun register(userEntry: UserEntry) : Observable<UserEntry>
    fun loadUserToken(): String
}
