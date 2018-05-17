package pro.itshark.moneysplitter.presentation.userProfile

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pro.itshark.moneysplitter.*
import pro.itshark.moneysplitter.databinding.ActivityUserProfileBinding
import pro.itshark.moneysplitter.utility.PreferenceHelper.defaultSharedPreferences
import pro.itshark.moneysplitter.utility.PreferenceHelper.set
import javax.inject.Inject

class UserProfileActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) = context.startActivity(Intent(context, UserProfileActivity::class.java))
    }

    @Inject
    lateinit var viewModel: UserProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityUserProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile)

        App.component.inject(this)

        initPref()

        binding.viewModel = viewModel
        viewModel.init()
    }

    // TODO delete in the future
    private fun initPref() {
        val pref = defaultSharedPreferences(this)

        pref[PrefKey.NAME] = "Yauheni"
        pref[PrefKey.SURNAME] = "Vasileuski"
        pref[PrefKey.EMAIL] = "email"
        pref[PrefKey.IMAGE_URL] = "https://cdn.img.inosmi.ru/images/24126/31/241263151.jpg"
    }
}
