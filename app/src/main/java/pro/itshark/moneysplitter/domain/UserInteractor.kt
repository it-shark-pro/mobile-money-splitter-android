package pro.itshark.moneysplitter.domain

import io.reactivex.Single
import pro.itshark.moneysplitter.model.repository.UserRepository
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

class UserInteractor(private val userRepository: UserRepository) : UserUseCases {

    override fun getUserInfo(): Single<UserModel> = userRepository.getUserInfo()
            .map { user ->
                UserModel(
                        user.id,
                        user.email,
                        user.name,
                        user.surname,
                        user.phoneNumber,
                        user.creditCardNumber,
                        user.balance,
                        user.token,
                        user.imageUrl,
                        user.backgroundImageUrl
                )
            }
}
