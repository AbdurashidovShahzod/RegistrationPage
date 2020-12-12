package uz.pdp.registrationpage.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import uz.pdp.registrationpage.R
import uz.pdp.registrationpage.utils.SharedPreferenceSwitch
import uz.pdp.registrationpage.utils.SharedPreferenceUI

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        SharedPreferenceSwitch.init(this)



        switchBtn.setOnCheckedChangeListener { _, _ ->
            var switch = SharedPreferenceSwitch.switch

            if (switchBtn.isChecked) {
                SharedPreferenceSwitch.switch = switch != true
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}

