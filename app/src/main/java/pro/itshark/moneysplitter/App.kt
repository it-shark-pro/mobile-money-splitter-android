package pro.itshark.moneysplitter

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import pro.itshark.moneysplitter.di.AppComponent
import pro.itshark.moneysplitter.di.DaggerAppComponent
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    companion object {

        lateinit var component: AppComponent
    }

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .application(this)
                .build()

        component.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}
