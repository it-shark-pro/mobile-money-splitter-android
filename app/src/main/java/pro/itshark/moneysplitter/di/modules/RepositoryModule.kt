package pro.itshark.moneysplitter.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.model.UserLocalStorage
import pro.itshark.moneysplitter.model.repository.UserRepository

@Module
class RepositoryModule {

    @Provides
    fun provideUserRepository(application: Application): UserRepository = UserLocalStorage(application)
}
