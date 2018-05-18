package pro.itshark.moneysplitter.presentation.regLogin

import pro.itshark.moneysplitter.model.pojo.UserEntry

sealed class RegLoginState

class OpenRegistrationState : RegLoginState()
data class OpenLoginState(val data: UserEntry) : RegLoginState()
data class OpenMainState(val data: UserEntry) : RegLoginState()