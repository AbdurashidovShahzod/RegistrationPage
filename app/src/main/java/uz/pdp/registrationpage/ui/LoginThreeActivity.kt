package uz.pdp.registrationpage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login_three.*
import uz.pdp.registrationpage.R
import uz.pdp.registrationpage.utils.SharedPreferenceUI

class LoginThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_three)
        SharedPreferenceUI.init(this)

//        textThree.text = SharedPreferenceUI.user
        val stringExtra = intent.getStringExtra("a")
        val stringExtra2 = intent.getStringExtra("b")

        textThree.text = "Login:$stringExtra\nParol:$stringExtra2"

    }


}