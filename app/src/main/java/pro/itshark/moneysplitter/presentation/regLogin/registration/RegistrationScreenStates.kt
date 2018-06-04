package pro.itshark.moneysplitter.presentation.regLogin.registration

import pro.itshark.moneysplitter.model.pojo.UserEntry

sealed class RegistrationScreenStates

class OpenRegistrationState: RegistrationScreenStates()
data class ErrorState(val errorMessage: String, val data: UserEntry) : RegistrationScreenStates()
data class SuccessState(val data: UserEntry) : RegistrationScreenStates()