package pro.itshark.moneysplitter.domain.friends

import io.reactivex.Observable
import pro.itshark.moneysplitter.model.repository.friends.FriendsRepository
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

class FriendsInteractor(private val friendsRepository: FriendsRepository) : FriendsUseCases {

    override fun getAllFriends(email: String, token: String): Observable<List<UserModel>> =
            friendsRepository.getAllFriends(email, token)
                    .map { entries -> entries.map { entry -> UserModel.create(entry) } }
}
