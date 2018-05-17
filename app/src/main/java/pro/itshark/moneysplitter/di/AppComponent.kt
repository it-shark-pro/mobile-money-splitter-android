package pro.itshark.moneysplitter.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import pro.itshark.moneysplitter.di.modules.NetworkModule
import pro.itshark.moneysplitter.di.modules.UserProfileModule
import pro.itshark.moneysplitter.presentation.userProfile.UserProfileActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, UserProfileModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(userProfileActivity: UserProfileActivity)
}
