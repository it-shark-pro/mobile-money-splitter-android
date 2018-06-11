package pro.itshark.moneysplitter.domain.friends

import io.reactivex.Observable
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

interface FriendsUseCases {

    fun getAllFriends(email: String, token: String): Observable<List<UserModel>>
}
