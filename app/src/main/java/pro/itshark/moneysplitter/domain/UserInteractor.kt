package pro.itshark.moneysplitter.domain

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.itshark.moneysplitter.model.pojo.User
import pro.itshark.moneysplitter.model.repository.UserRepository
import pro.itshark.moneysplitter.presentation.login.LoginUserViewModel
import pro.itshark.moneysplitter.presentation.registration.RegisterUserViewModel

class UserInteractor(private val userRepository: UserRepository) : UserUseCases {
    override fun login(credits: User): Observable<LoginUserViewModel>{
        return userRepository.login(credits)
                .map { userResponse -> userResponse.body()}
                .map { user ->
                    Log.d("TestPishLogin", "user = " +user.email)
                    Log.d("TestPishLogin", "password = " +user.password)
                    LoginUserViewModel(user.email, user.password!!)}
    }

    override fun register(credits: User): Observable<RegisterUserViewModel> {
        return userRepository.register(credits)
                .map { userResponse -> userResponse.body() }
                .map { user ->
                    RegisterUserViewModel(user.password!!,
                            user.image,
                            user.background,
                            user.email,
                            user.userName,
                            user.surname,
                            user.phoneNumber,
                            user.creditCardNumber)
                }
    }
}