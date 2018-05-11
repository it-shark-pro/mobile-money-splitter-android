package pro.itshark.moneysplitter

import android.app.Application
import pro.itshark.moneysplitter.di.AppComponent
import pro.itshark.moneysplitter.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .build()
    }
}