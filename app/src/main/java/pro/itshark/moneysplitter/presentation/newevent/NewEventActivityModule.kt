package pro.itshark.moneysplitter.presentation.newevent

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent
interface NewEventSubcomponent: AndroidInjector<NewEventActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<NewEventActivity>()
}

@Module(subcomponents = [(NewEventSubcomponent::class)])
abstract class NewEventActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(NewEventActivity::class)
    abstract fun bindAddEventActivity(builder: NewEventSubcomponent.Builder): AndroidInjector.Factory<out Activity>
}