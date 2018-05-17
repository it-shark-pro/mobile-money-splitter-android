package pro.itshark.moneysplitter.di.modules

import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.model.api.Api
import pro.itshark.moneysplitter.model.repository.UserDownloader
import pro.itshark.moneysplitter.model.repository.UserRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(api: Api): UserRepository = UserDownloader(api)
}