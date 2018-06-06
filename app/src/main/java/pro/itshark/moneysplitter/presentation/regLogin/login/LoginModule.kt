package pro.itshark.moneysplitter.presentation.regLogin.login

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap


@Subcomponent
interface LoginSubcomponent: AndroidInjector<LoginFragment> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<LoginFragment>()
}

@Module(subcomponents = [(LoginSubcomponent::class)])
abstract class LoginModule {
    @Binds
    @IntoMap
    @FragmentKey(LoginFragment::class)
    abstract fun bindLoginFragment(builder: LoginSubcomponent.Builder): AndroidInjector.Factory<out Fragment>
}