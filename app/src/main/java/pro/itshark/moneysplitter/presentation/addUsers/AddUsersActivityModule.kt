package pro.itshark.moneysplitter.presentation.addUsers

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent
interface UsersSubcomponent : AndroidInjector<AddUsersActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<AddUsersActivity>()
}

@Module(subcomponents = [(UsersSubcomponent::class)])
abstract class AddUsersActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(AddUsersActivity::class)
    abstract fun bindEventsActivity(builder: UsersSubcomponent.Builder): AndroidInjector.Factory<out Activity>
}
