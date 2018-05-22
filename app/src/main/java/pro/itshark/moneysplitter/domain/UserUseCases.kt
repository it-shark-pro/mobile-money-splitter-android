package pro.itshark.moneysplitter.domain

import io.reactivex.Single
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

interface UserUseCases {

    fun getUserInfo(): Single<UserModel>
}
