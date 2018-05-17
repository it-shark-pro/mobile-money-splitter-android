package pro.itshark.moneysplitter.di.modules

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pro.itshark.moneysplitter.presentation.regLogin.login.LoginViewModel
import kotlin.reflect.KClass

@Module(includes = [(ApplicationModule::class), (UseCasesModule::class)]
class ViewModelModule {

    @Provides
    fun bindLoginViewModel(viewModel: LoginViewModel) : ViewModel {
        return LoginViewModel()
    }
}