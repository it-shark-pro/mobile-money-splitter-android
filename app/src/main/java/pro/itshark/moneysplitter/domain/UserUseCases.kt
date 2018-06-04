package pro.itshark.moneysplitter.domain

import io.reactivex.Observable
import io.reactivex.Single
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

interface UserUseCases {

    fun getUserInfo(): Single<UserModel>
    fun register(userEntry: UserEntry) : Observable<UserEntry>
    fun login(email: String, password: String) : Observable<UserEntry>
}
