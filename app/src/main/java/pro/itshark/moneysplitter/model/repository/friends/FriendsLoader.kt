package pro.itshark.moneysplitter.model.repository.friends

import io.reactivex.Observable
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.pojo.UserEntry

class FriendsLoader(private val api: Api) : FriendsRepository {

    override fun getAllFriends(email: String, token: String): Observable<List<UserEntry>> =
            api.getAllFriends(email, token)
}
