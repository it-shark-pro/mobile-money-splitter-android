package pro.itshark.moneysplitter.model.repository.friends

import io.reactivex.Observable
import pro.itshark.moneysplitter.model.pojo.UserEntry

interface FriendsRepository {

    fun getAllFriends(email: String, token: String): Observable<List<UserEntry>>
}
