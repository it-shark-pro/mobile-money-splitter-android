package pro.itshark.moneysplitter.di.modules

import dagger.Module
import dagger.Provides
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.presentation.userProfile.UserProfileViewModel

@Module
class ViewModelModule {

    @Provides
    fun provideUserProfileViewModel(userUseCases: UserUseCases): UserProfileViewModel = UserProfileViewModel(userUseCases)
}
