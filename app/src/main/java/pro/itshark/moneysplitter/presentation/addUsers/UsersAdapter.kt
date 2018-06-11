package pro.itshark.moneysplitter.presentation.addUsers

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.common.RecyclerBaseAdapter
import pro.itshark.moneysplitter.presentation.userProfile.UserModel

class UsersAdapter(private val owner: LifecycleOwner, var items: List<UserModel>) : RecyclerBaseAdapter() {

    private val selectedUsers: MutableMap<Long, UserModel> = mutableMapOf()

    private val stateViewModelObserver = Observer<UserItemViewModel.State> { state ->
        state?.let {
            when (state) {
                is UserItemViewModel.State.Default -> {
                }
                is UserItemViewModel.State.Added -> selectedUsers.put(state.user.id, state.user)
                is UserItemViewModel.State.Removed -> selectedUsers.remove(state.user.id)
            }
        }
    }

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.adapter_user_item

    override fun getViewModel(position: Int): Any? {
        val viewModel = UserItemViewModel(items[position], selectedUsers.contains(items[position].id))

        viewModel.state.observe(owner, stateViewModelObserver)

        return viewModel
    }

    override fun getItemCount(): Int = items.size

    fun update(usersList: List<UserModel>, selectedUsers: Map<Long, UserModel>) {
        items = usersList.toMutableList()
        this.selectedUsers.putAll(selectedUsers)

        notifyDataSetChanged()
    }

    fun getSelectedUsersAsMap(): Map<Long, UserModel> = selectedUsers

    fun getSelectedUsersAsArray(): Array<UserModel> = selectedUsers.values.toTypedArray()
}
