package pro.itshark.moneysplitter.presentation.events

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent
interface EventsSubcomponent: AndroidInjector<EventsActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<EventsActivity>()
}

@Module(subcomponents = [(EventsSubcomponent::class)])
abstract class EventsActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(EventsActivity::class)
    abstract fun bindEventsActivity(builder: EventsSubcomponent.Builder): AndroidInjector.Factory<out Activity>
}
