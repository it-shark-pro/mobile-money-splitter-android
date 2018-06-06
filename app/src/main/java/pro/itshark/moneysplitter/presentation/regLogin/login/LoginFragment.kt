package pro.itshark.moneysplitter.presentation.regLogin.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_login.*
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.databinding.FragmentLoginBinding
import pro.itshark.moneysplitter.presentation.events.EventsActivity
import pro.itshark.moneysplitter.presentation.regLogin.RegLoginViewModel
import javax.inject.Inject

class LoginFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: LoginViewModel
    lateinit var loginActions: LoginActions

    private val stateObserver = Observer<LoginScreenState> { state ->
        state?.let {
            when (state) {
                is LoginErrorState -> {}
                is LoginSuccessState -> {
                    context?.let {
                        EventsActivity.start(it)
                    }
                }

                is OpenRegistrationState -> {
                    loginActions.onOpenRegistration()
                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container,false)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        viewModel.stateLiveData.observe(this, stateObserver)
        binding.viewModel = viewModel

        val regLoginViewModel = ViewModelProviders.of(this, viewModelFactory).get(RegLoginViewModel::class.java)
        binding.regLoginViewModel = regLoginViewModel

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        viewModel.stateLiveData.removeObserver(stateObserver)
    }
}