package pro.itshark.moneysplitter.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins.onSubscribe
import io.reactivex.schedulers.Schedulers
import okhttp3.Response
import okhttp3.ResponseBody
import pro.itshark.moneysplitter.App
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.model.api.Api
import javax.inject.Inject

class EventsActivity : AppCompatActivity() {

    @Inject
    lateinit var api : Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        App.component.inject(this)

        Log.d("TestPish", "api = " +api)
        api.register("testPassword", "testEncImage", "testBackground", "testEmail", "testName", "testSurname", "testPhone", "testCreditCard")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    fun onSubscribe(d : Disposable){
                        Log.d("TestPish", "onSubscribe")
                    }

                    fun onSuccess(items : List<ResponseBody>) {
                        Log.d("TestPish", "onSuccess")
                    }

                    fun onError(e: Throwable) {
                        Log.d("TestPish", "e")
                    }
                })
    }
}
