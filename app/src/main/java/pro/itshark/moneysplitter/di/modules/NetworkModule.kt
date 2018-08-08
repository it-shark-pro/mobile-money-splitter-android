package pro.itshark.moneysplitter.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import pro.itshark.moneysplitter.BASE_URL
import pro.itshark.moneysplitter.Timeout
import pro.itshark.moneysplitter.model.api.Api
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(Timeout.connect, TimeUnit.SECONDS)
            .readTimeout(Timeout.read, TimeUnit.SECONDS)
            .writeTimeout(Timeout.write, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): Api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build().create(Api::class.java)
}
