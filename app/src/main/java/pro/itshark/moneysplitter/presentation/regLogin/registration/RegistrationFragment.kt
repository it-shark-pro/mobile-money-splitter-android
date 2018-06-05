package pro.itshark.moneysplitter.presentation.regLogin.registration

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
import kotlinx.android.synthetic.main.fragment_registration.*
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.databinding.FragmentRegistrationBinding
import pro.itshark.moneysplitter.presentation.regLogin.RegLoginActivityViewModel
import javax.inject.Inject

class RegistrationFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: RegistrationViewModel

    private val stateObserver = Observer<RegistrationScreenStates> { state ->
        state?.let {
            when (state) {
                is RegistrationSuccessState -> text_view_registration_error_message.visibility = View.INVISIBLE
                is RegistrationErrorState -> text_view_registration_error_message.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRegistrationBinding>(inflater, R.layout.fragment_registration, container,false)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RegistrationViewModel::class.java)
        viewModel.stateLiveData.observe(this, stateObserver)
        binding.viewModel = viewModel

        val regLoginViewModel = ViewModelProviders.of(this, viewModelFactory).get(RegLoginActivityViewModel::class.java)
        binding.regLoginViewModel = regLoginViewModel

        return binding.root
    }
}
