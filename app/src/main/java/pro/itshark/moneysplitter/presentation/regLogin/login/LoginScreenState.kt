package pro.itshark.moneysplitter.presentation.regLogin.login

import pro.itshark.moneysplitter.model.pojo.UserEntry

sealed class LoginScreenState {
    abstract val data: UserEntry
}

data class DefaultState(override val data: UserEntry) : LoginScreenState()
data class LoadingState(override val data: UserEntry) : LoginScreenState()
data class ErrorState(val errorMessage: String, override val data: UserEntry) : LoginScreenState()
data class SuccessState(override val data: UserEntry) : LoginScreenState()