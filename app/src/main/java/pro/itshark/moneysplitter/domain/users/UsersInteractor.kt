package pro.itshark.moneysplitter.domain.users

import io.reactivex.Observable
import io.reactivex.Single
import pro.itshark.moneysplitter.model.pojo.UserEntry
import pro.itshark.moneysplitter.model.repository.users.UsersRepository
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

class UsersInteractor(private val usersRepository: UsersRepository) : UsersUseCases {

    override fun getUserInfo(): Single<UserModel> = usersRepository.getUserInfo()
            .map { user ->
                UserModel.create(user)
            }

    override fun login(userEntry: UserEntry): Single<UserEntry> {
        return usersRepository.login(userEntry)
    }

    override fun register(userEntry: UserEntry): Single<UserEntry> {
        return usersRepository.register(userEntry)
    }

    override fun saveUserInfo(userEntry: UserEntry) {
        return usersRepository.saveUserInfo(userEntry)
    }

    override fun loadUserToken(): String {
        return usersRepository.loadUserToken()
    }

    override fun searchUsers(value: String): Observable<List<UserModel>> =
            usersRepository.searchUsers(value)
                    .map { entries -> entries.map { entry -> UserModel.create(entry) } }
}
