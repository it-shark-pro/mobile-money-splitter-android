package pro.itshark.moneysplitter.presentation.regLogin.registration

sealed class RegistrationScreenStates
class RegistrationErrorState: RegistrationScreenStates()
class RegistrationSuccessState: RegistrationScreenStates()
class RegistrationRequestSendState: RegistrationScreenStates()
