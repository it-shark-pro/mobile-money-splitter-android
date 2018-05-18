package pro.itshark.moneysplitter.presentation.regLogin.login

import pro.itshark.moneysplitter.model.pojo.UserEntry

sealed class LoginScreenState

class OpenRegistrationState: LoginScreenState()
data class ErrorState(val errorMessage: String, val data: UserEntry) : LoginScreenState()
data class SuccessState(val data: UserEntry) : LoginScreenState()