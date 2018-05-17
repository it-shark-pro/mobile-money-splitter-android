package pro.itshark.moneysplitter.presentation.userProfile

import android.databinding.BaseObservable
import android.databinding.Bindable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pro.itshark.moneysplitter.BR
import pro.itshark.moneysplitter.domain.UserUseCases

class UserProfileViewModel(private val userUseCases: UserUseCases) : BaseObservable() {

    private var userModel: UserModel? = null

    @Bindable
    fun getName(): String = userModel?.name ?: ""

    @Bindable
    fun getSurname(): String = userModel?.surname ?: ""

    @Bindable
    fun getImageUrl(): String = userModel?.imageUrl ?: ""

    fun init() {
        userUseCases.getUserInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ user ->
                    userModel = user

                    notifyPropertyChanged(BR.name)
                    notifyPropertyChanged(BR.surname)
                    notifyPropertyChanged(BR.imageUrl)
                }, { error ->
                    error.printStackTrace()
                })
    }
}
