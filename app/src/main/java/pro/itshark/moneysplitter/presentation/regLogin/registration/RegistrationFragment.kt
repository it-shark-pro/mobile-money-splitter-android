package pro.itshark.moneysplitter.presentation.regLogin.registration

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*
import pro.itshark.moneysplitter.App
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.presentation.regLogin.login.ErrorState
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginScreenState
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginViewModel
import pro.itshark.moneysplitter.presentation.regLogin.login.SuccessState
import javax.inject.Inject

class RegistrationFragment: Fragment() {
    @Inject
    lateinit var viewModel: LoginViewModel

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

        App.component.inject(this)
        viewModel.stateLiveData.observe(this, stateObserver)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
/*        super.onViewCreated(view, savedInstanceState)

        buttonLogin.setOnClickListener {
            val email = edit_text_email_input.text.toString()
            val password = edit_text_password.text.toString()
            viewModel.login(email, password)
        }*/
    }
}