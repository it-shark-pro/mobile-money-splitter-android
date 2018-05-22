package pro.itshark.moneysplitter.presentation.userProfile

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import pro.itshark.moneysplitter.PreferenceKey
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.common.PreferenceHelper.defaultSharedPreferences
import pro.itshark.moneysplitter.common.PreferenceHelper.set
import pro.itshark.moneysplitter.databinding.ActivityUserProfileBinding
import javax.inject.Inject

class UserProfileActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) = context.startActivity(Intent(context, UserProfileActivity::class.java))
    }

    @Inject
    lateinit var viewMOdelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: UserProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPref()
        AndroidInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewMOdelFactory).get(UserProfileViewModel::class.java)

        val binding: ActivityUserProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile)

        binding.viewModel = viewModel
    }

    // TODO delete in the future
    private fun initPref() {
        val pref = defaultSharedPreferences(this)

        pref[PreferenceKey.NAME] = "Yauheni"
        pref[PreferenceKey.SURNAME] = "Vasileuski"
        pref[PreferenceKey.EMAIL] = "email"
        pref[PreferenceKey.IMAGE_URL] = "https://cdn.img.inosmi.ru/images/24126/31/241263151.jpg"
    }
}
