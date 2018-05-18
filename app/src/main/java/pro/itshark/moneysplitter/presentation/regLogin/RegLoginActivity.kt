package pro.itshark.moneysplitter.presentation.regLogin

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.presentation.regLogin.login.*
import pro.itshark.moneysplitter.presentation.regLogin.registration.RegistrationFragment
import javax.inject.Inject

class RegLoginActivity: AppCompatActivity() {
    @Inject
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
        setContentView(R.layout.activity_start)

        viewModel.stateLiveData.observe(this, stateObserver)
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
