package uz.pdp.registrationpage.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first_contact.*
import uz.pdp.registrationpage.R

class FirstContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_contact)


        contactListBtn.setOnClickListener {
            startActivity(Intent(this, SecondContactActivity::class.java))
        }
        contactAddBtn.setOnClickListener {
            startActivity(Intent(this, ThreeContactActivity::class.java))
        }


    }
}