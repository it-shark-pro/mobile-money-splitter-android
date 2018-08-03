package pro.itshark.moneysplitter.presentation.addUsers

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_add_users.*
import pro.itshark.moneysplitter.IntentKey
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.databinding.ActivityAddUsersBinding
import javax.inject.Inject

class AddUsersActivity : AppCompatActivity() {

    companion object {
        fun startForResult(activity: Activity, requestCode: Int) =
                activity.startActivityForResult(Intent(activity, AddUsersActivity::class.java), requestCode)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: AddUsersViewModel

    private val adapter = UsersAdapter(this, listOf())

    private val stateViewModelObserver = Observer<AddUsersViewModel.State> { state ->
        state?.let {
            when (state) {
                is AddUsersViewModel.State.Success -> adapter.update(state.usersList, state.selectedUsers)
                is AddUsersViewModel.State.Error -> Toast.makeText(this, getString(R.string.failed), Toast.LENGTH_SHORT).show()
                is AddUsersViewModel.State.Confirm -> {
                    setResult(Activity.RESULT_OK, Intent().putExtra(IntentKey.users, adapter.getSelectedUsers().values.toTypedArray()))
                    finish()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchView = search_view

        menu?.findItem(R.id.action_search).let { searchView.setMenuItem(it) }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }

        return true
    }

    private fun init() {
        AndroidInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AddUsersViewModel::class.java)
        viewModel.stateViewModel.observe(this, stateViewModelObserver)

        DataBindingUtil.setContentView<ActivityAddUsersBinding>(this, R.layout.activity_add_users).viewModel = viewModel

        initToolbar()
        initRecyclerView()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)

        supportActionBar?.title = getString(R.string.add_users)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initRecyclerView() {
        val usersRecyclerView = users_recycler_view

        usersRecyclerView.layoutManager = LinearLayoutManager(this)
        usersRecyclerView.setHasFixedSize(true)
        usersRecyclerView.addItemDecoration(DividerItemDecoration(usersRecyclerView.context, DividerItemDecoration.VERTICAL))
        usersRecyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()

        viewModel.stateViewModel.removeObserver(stateViewModelObserver)
    }
}
