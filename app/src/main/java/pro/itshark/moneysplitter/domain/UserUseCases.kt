package pro.itshark.moneysplitter.domain

import io.reactivex.Observable
import pro.itshark.moneysplitter.model.pojo.UserEntry

interface UserUseCases{
    //fun register(email: String, password: String) : Observable<UserEntry>
    fun login(email: String, password: String) : Observable<UserEntry>
}