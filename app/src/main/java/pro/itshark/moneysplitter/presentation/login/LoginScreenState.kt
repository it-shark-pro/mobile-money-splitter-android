package pro.itshark.moneysplitter.presentation.login

import pro.itshark.moneysplitter.model.pojo.User

sealed class LoginScreenState {
    abstract val data: User
}

data class DefaultState(override val data: User) : LoginScreenState()
data class LoadingState(override val data: User) : LoginScreenState()
data class ErrorState(val errorMessage: String, override val data: User) : LoginScreenState()
data class SuccessState(override val data: User) : LoginScreenState()