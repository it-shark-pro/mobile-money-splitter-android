package pro.itshark.moneysplitter.presentation.regLogin.registration

import android.os.Bundle
import android.support.v4.app.Fragment
import pro.itshark.moneysplitter.App
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginViewModel
import javax.inject.Inject

/**
 * Created by i_straj_i on 17.05.2018.
 */

class RegistrationFragment: Fragment() {
    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.component.inject(this)
        viewModel.stateLiveData.observe(this, stateObserver)
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