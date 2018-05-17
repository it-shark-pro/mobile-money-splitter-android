package pro.itshark.moneysplitter.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pro.itshark.moneysplitter.R
import pro.itshark.moneysplitter.model.pojo.UserEntry

class EventsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)


/*
        val user = UserEntry("password", "testEncImg", "testBackgr", "testEmail14", "testName11", "testSurname", 212121220, 999999991, null)

        api.register(user)


*/

        val user2 = UserEntry("1234abcd", "vlad_nagibator12@mail.ru")

/*        api.login(user2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({ first ->
                    run {
                        Log.d("TestPish", "token: " + first.code())
                        Log.d("TestPish", "notToken: " +first.body()?.token)
                    }
                }, {error -> Log.d("TestPish", "error = " +error.localizedMessage)})*/
    }
}
