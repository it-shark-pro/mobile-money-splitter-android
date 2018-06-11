package pro.itshark.moneysplitter.domain.users

import io.reactivex.Observable
import io.reactivex.Single
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

interface UsersUseCases {

    fun getUserInfo(): Single<UserModel>

    fun register(userEntry: UserEntry): Single<UserEntry>

    fun login(userEntry: UserEntry): Single<UserEntry>

    fun saveUserInfo(userEntry: UserEntry)

    fun loadUserToken(): String

    fun searchUsers(value: String): Observable<List<UserModel>>
}
