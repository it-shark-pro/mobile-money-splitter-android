package pro.itshark.moneysplitter

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import pro.itshark.moneysplitter.di.AppComponent
import pro.itshark.moneysplitter.di.DaggerAppComponent
import pro.itshark.moneysplitter.di.modules.DBModule
import javax.inject.Inject

class App : Application(), HasActivityInjector, HasSupportFragmentInjector {

    companion object {
        lateinit var component: AppComponent
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .application(this)
                .setDBModule(DBModule(this))
                .build()

        component.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = androidInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}
