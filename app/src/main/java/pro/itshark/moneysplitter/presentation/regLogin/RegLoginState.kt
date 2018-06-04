package pro.itshark.moneysplitter.presentation.regLogin

sealed class RegLoginState
class OpenRegistrationState : RegLoginState()
class OpenLoginState : RegLoginState()
class OpenMainState : RegLoginState()