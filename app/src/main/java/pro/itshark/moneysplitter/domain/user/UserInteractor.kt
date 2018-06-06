package pro.itshark.moneysplitter.domain.user

import io.reactivex.Observable
import io.reactivex.Single
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.model.repository.user.UserRepository
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

class UserInteractor(private val userRepository: UserRepository) : UserUseCases {

    override fun getUserInfo(): Single<UserModel> = userRepository.getUserInfo()
            .map {user ->
                UserModel.create(user)
            }

    override fun login(userEntry: UserEntry): Single<UserEntry> {
        return userRepository.login(userEntry)
    }

    override fun register(userEntry: UserEntry): Single<UserEntry> {
        return userRepository.register(userEntry)
    }

    override fun saveUserInfo(userEntry: UserEntry) {
        return userRepository.saveUserInfo(userEntry)
    }

    override fun loadUserToken(): String {
        return userRepository.loadUserToken()
    }
}
