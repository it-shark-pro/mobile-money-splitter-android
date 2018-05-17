package pro.itshark.moneysplitter.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.domain.UserInteractor
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.model.UserLocalStorage
import pro.itshark.moneysplitter.model.repository.UserRepository
import pro.itshark.moneysplitter.presentation.userProfile.UserProfileViewModel

@Module
class UserProfileModule {

    @Provides
    fun provideUserRepository(application: Application): UserRepository = UserLocalStorage(application)

    @Provides
    fun provideUserUseCases(userRepository: UserRepository): UserUseCases = UserInteractor(userRepository)

    @Provides
    fun provideUserProfileViewModel(userUseCases: UserUseCases): UserProfileViewModel = UserProfileViewModel(userUseCases)
}
