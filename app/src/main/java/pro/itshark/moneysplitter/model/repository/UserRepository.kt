package pro.itshark.moneysplitter.model.repository

import io.reactivex.Observable
import pro.itshark.moneysplitter.model.pojo.User
import retrofit2.Response

interface UserRepository {
    fun login(user: User) : Observable<Response<User>>
    fun register(user: User) : Observable<Response<User>>
}