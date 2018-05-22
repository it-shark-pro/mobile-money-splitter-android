package pro.itshark.moneysplitter.di.modules

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import pro.itshark.moneysplitter.presentation.newevent.NewEventViewModel
import dagger.Provides
import pro.itshark.moneysplitter.domain.UserUseCases
import pro.itshark.moneysplitter.domain.events.EventsUseCases
import pro.itshark.moneysplitter.presentation.events.EventsViewModel
import pro.itshark.moneysplitter.presentation.userProfile.UserProfileViewModel
import kotlin.reflect.KClass


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NewEventViewModel::class)
    abstract fun bindNewEventViewModel(viewModel: NewEventViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel::class)
    abstract fun bindUserProfileViewMOdel(viewModel: UserProfileViewModel) : ViewModel


    @Provides
    fun provideEventsViewModel(eventsUseCases: EventsUseCases): EventsViewModel = EventsViewModel(eventsUseCases)
}
