package pro.itshark.moneysplitter.presentation.userProfile

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent
interface UserProfileSubcomponent: AndroidInjector<UserProfileActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<UserProfileActivity>()
}

@Module(subcomponents = [(UserProfileSubcomponent::class)])
abstract class UserProfileActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(UserProfileActivity::class)
    abstract fun bindUserProfileActivity(builder: UserProfileSubcomponent.Builder): AndroidInjector.Factory<out Activity>
}