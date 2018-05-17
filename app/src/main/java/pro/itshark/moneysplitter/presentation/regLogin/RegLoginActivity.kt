package pro.itshark.moneysplitter.presentation.regLogin

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.fragment_login.*
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.presentation.regLogin.login.ErrorState
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginFragment
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginScreenState
import pro.itshark.moneysplitter.presentation.regLogin.login.SuccessState
import pro.itshark.moneysplitter.presentation.regLogin.registration.RegistrationFragment

class RegLoginActivity: AppCompatActivity() {

    private val stateObserver = Observer<LoginScreenState> { state ->
        state?.let {
            when (state) {
                is ErrorState -> {
                    frameLayoutLoginErrorView.visibility = View.VISIBLE
                    text_view_login_result_text.setText("Error")
                }

                is SuccessState -> {
                    frameLayoutLoginErrorView.visibility = View.INVISIBLE
                    text_view_login_result_text.setText("Succes")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        viewModel.stateLiveData.observe(this, stateObserver)
        openLogin()
    }

    fun openLogin() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, LoginFragment())
                .commit()
    }

    fun openRegistration(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RegistrationFragment())
                .commit()
    }
}
