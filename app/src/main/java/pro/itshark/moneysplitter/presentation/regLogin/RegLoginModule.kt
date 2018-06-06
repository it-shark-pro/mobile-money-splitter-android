package pro.itshark.moneysplitter.presentation.regLogin

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent
interface RegLoginSubcomponent: AndroidInjector<RegLoginActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<RegLoginActivity>()
}

@Module(subcomponents = [(RegLoginSubcomponent::class)])
abstract class RegLoginModule {
    @Binds
    @IntoMap
    @ActivityKey(RegLoginActivity::class)
    abstract fun bindRegLoginActivity(builder: RegLoginSubcomponent.Builder): AndroidInjector.Factory<out Activity>
}
