package uz.pdp.registrationpage.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sdsmdg.tastytoast.TastyToast
import kotlinx.android.synthetic.main.activity_main.*
import uz.pdp.registrationpage.R
import uz.pdp.registrationpage.utils.SharedPreferenceSwitch
import uz.pdp.registrationpage.utils.SharedPreferenceUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SharedPreferenceSwitch.init(this)

        var switchData = SharedPreferenceSwitch.switch

        Toast.makeText(this, switchData.toString(), Toast.LENGTH_SHORT).show()
        if (switchData == true) {
            TastyToast.makeText(
                this,
                "Rang o'zgardi",
                Toast.LENGTH_SHORT,
                TastyToast.SUCCESS
            ).show()
            mainC.setBackgroundColor(Color.BLACK)
        } else if (switchData == false) {
            mainC.setBackgroundColor(Color.RED)
            TastyToast.makeText(
                this,
                "Rang o'zgardi",
                Toast.LENGTH_SHORT,
                TastyToast.SUCCESS
            ).show()
        }

        clickBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}