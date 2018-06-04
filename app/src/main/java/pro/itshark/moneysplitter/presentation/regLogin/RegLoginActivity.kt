package pro.itshark.moneysplitter.presentation.regLogin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.AndroidInjection
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.databinding.ActivityStartBinding
import pro.itshark.moneysplitter.presentation.regLogin.login.*
import pro.itshark.moneysplitter.presentation.regLogin.registration.RegistrationFragment

import javax.inject.Inject

class RegLoginActivity: AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: RegLoginActivityViewModel

    private val stateObserver = Observer<RegLoginState> { state ->
        state?.let {
            when (state) {
                is OpenLoginState -> openLogin()
                is OpenRegistrationState -> openRegistration()
                is OpenMainState -> openMain()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RegLoginActivityViewModel::class.java)
        viewModel.stateLiveData.observe(this, stateObserver)

        val binding: ActivityStartBinding  = DataBindingUtil.setContentView(this, R.layout.activity_start)
        binding.viewModel = viewModel
    }

    private fun openLogin() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, LoginFragment())
                .commit()
    }

    private fun openRegistration() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RegistrationFragment())
                .commit()
    }

    private fun openMain() {

    }
}