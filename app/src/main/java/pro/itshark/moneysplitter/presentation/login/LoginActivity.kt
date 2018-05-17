package pro.itshark.moneysplitter.presentation.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pro.itshark.moneysplitter.R
class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, LoginFragment())
                .commit()
    }
}
