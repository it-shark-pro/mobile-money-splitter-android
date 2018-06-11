package pro.itshark.moneysplitter.presentation.userProfile

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.databinding.ActivityUserProfileBinding
import javax.inject.Inject

class UserProfileActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) = context.startActivity(Intent(context, UserProfileActivity::class.java))
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: UserProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        AndroidInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserProfileViewModel::class.java)

        DataBindingUtil.setContentView<ActivityUserProfileBinding>(this, R.layout.activity_user_profile).viewModel = viewModel
    }
}
