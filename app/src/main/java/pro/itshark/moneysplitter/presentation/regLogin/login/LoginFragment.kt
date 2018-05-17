package pro.itshark.moneysplitter.presentation.regLogin.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*
import pro.itshark.moneysplitter.App
import pro.itshark.moneysplitter.R
import javax.inject.Inject

class LoginFragment: Fragment() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin.setOnClickListener {
            val email = edit_text_email_input.text.toString()
            val password = edit_text_password.text.toString()
            viewModel.login(email, password)
        }
    }
}