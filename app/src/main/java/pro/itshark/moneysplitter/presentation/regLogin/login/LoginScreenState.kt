package pro.itshark.moneysplitter.presentation.regLogin.login

import pro.itshark.moneysplitter.model.pojo.UserEntry

sealed class LoginScreenState

class OpenRegistrationState: LoginScreenState()
data class LoginErrorState(val errorMessage: String) : LoginScreenState()
data class LoginSuccessState(val data: UserEntry) : LoginScreenState()