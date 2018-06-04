package pro.itshark.moneysplitter.domain

import io.reactivex.Observable
import io.reactivex.Single
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.model.repository.UserRepository
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

class UserInteractor(private val userRepository: UserRepository) : UserUseCases {

    override fun getUserInfo(): Single<UserModel> = userRepository.getUserInfo()
            .map { user ->
                UserModel.create(user)
            }


    override fun login(email: String, password: String): Observable<UserEntry> {
        return userRepository.login(email, password)
        //.updateUserData

/*                    Log.d("TestPishLogin", "user = " +user.email)
                    Log.d("TestPishLogin", "password = " +user.password)
                    LoginUserViewModel(user.email, user.password!!)}*/
    }

    override fun register(userEntry: UserEntry): Observable<UserEntry> {
        return userRepository.register(userEntry)
    }
/*    override fun register(credits: UserEntry): Observable<UserEntry> {
        return userRepository.register(credits)
*//*                .map { user ->
                    RegisterUserViewModel(user.password!!,
                            user.image,
                            user.background,
                            user.email,
                            user.userName,
                            user.surname,
                            user.phoneNumber,
                            user.creditCardNumber)
                }*//*
    }*/
}
