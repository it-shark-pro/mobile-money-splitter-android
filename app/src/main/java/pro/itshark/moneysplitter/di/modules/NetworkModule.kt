package pro.itshark.moneysplitter.di.modules

import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.BASE_URL
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.presentation.login.LoginViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApi(): Api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(Api::class.java)
}