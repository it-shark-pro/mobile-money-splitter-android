package pro.itshark.moneysplitter.presentation.addUsers

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

class UserItemViewModel(val user: UserModel, isSelected: Boolean) : ViewModel() {

    val state = MutableLiveData<State>()
    val isSelect = ObservableBoolean(isSelected)

    init {
        state.value = State.Default(user)
    }

    fun onItemClick(user: UserModel) {
        isSelect.set(!isSelect.get())

        state.value = if (isSelect.get()) State.Added(user) else State.Removed(user)
    }

    sealed class State {
        abstract val user: UserModel

        data class Default(override val user: UserModel) : State()
        data class Added(override val user: UserModel) : State()
        data class Removed(override val user: UserModel) : State()
    }
}
