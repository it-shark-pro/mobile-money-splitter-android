package pro.itshark.moneysplitter.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import pro.itshark.moneysplitter.model.pojo.MyObjectBox
import javax.inject.Singleton

@Module
class DBModule(context: Context) {

    private var boxStore: BoxStore = MyObjectBox.builder().androidContext(context).build()

    @Provides
    @Singleton
    fun provideBoxStore(): BoxStore = boxStore

}