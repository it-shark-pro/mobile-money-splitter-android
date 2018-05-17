package pro.itshark.moneysplitter.domain

import io.reactivex.Observable
import pro.itshark.moneysplitter.model.pojo.User
import pro.itshark.moneysplitter.presentation.login.LoginUserViewModel
import pro.itshark.moneysplitter.presentation.registration.RegisterUserViewModel

interface UserUseCases{
    fun register(credits: User) : Observable<RegisterUserViewModel>
    fun login(credits: User) : Observable<LoginUserViewModel>
}