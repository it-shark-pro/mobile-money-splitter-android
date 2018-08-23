package pro.itshark.moneysplitter.presentation.events.details

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent
interface EventDetailSubcomponent: AndroidInjector<EventDetailActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<EventDetailActivity>()
}

@Module(subcomponents = [(EventDetailSubcomponent::class)])
abstract class EventDetailModule {
    @Binds
    @IntoMap
    @ActivityKey(EventDetailActivity::class)
    abstract fun bindEventDetailActivity(builder: EventDetailSubcomponent.Builder): AndroidInjector.Factory<out Activity>
}