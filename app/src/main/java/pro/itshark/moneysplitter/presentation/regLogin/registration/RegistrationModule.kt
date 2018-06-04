package pro.itshark.moneysplitter.presentation.regLogin.registration

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Subcomponent
interface RegistrationSubcomponent: AndroidInjector<RegistrationFragment> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<RegistrationFragment>()
}

@Module(subcomponents = [(RegistrationSubcomponent::class)])
abstract class RegistrationModule {
    @Binds
    @IntoMap
    @FragmentKey(RegistrationFragment::class)
    abstract fun bindRegistrationFragment(builder: RegistrationSubcomponent.Builder): AndroidInjector.Factory<out Fragment>
}