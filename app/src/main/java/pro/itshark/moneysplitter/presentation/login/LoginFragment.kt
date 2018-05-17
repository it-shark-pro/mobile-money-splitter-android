package pro.itshark.moneysplitter.presentation.login

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import pro.itshark.moneysplitter.App
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.model.pojo.User
import javax.inject.Inject

class LoginFragment: Fragment() {

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
        observeViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        initButton(view)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    private fun observeViewModel() {
        viewModel.stateLiveData.observe(this, stateObserver)
    }

    private fun initButton(view: View) {
        view.buttonLogin.setOnClickListener {
            run {
                val email = edit_text_email_input.text.toString()
                val password = edit_text_password.text.toString()
                Log.d("TestPish", "email = " +email +" password = " +password)
                val credits = User(password, email)
                viewModel.login(credits)
            }
        }
    }
}