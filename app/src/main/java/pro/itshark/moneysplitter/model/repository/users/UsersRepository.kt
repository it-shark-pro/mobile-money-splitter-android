package pro.itshark.moneysplitter.model.repository.users

import io.reactivex.Observable
import io.reactivex.Single
import pro.itshark.moneysplitter.model.pojo.UserEntry

interface UsersRepository {

    fun saveUserInfo(userEntry: UserEntry)

    fun getUserInfo(): Single<UserEntry>

    fun login(userEntry: UserEntry): Single<UserEntry>

    fun register(userEntry: UserEntry): Single<UserEntry>

    fun loadUserToken(): String

    fun searchUsers(value: String): Observable<List<UserEntry>>
}
