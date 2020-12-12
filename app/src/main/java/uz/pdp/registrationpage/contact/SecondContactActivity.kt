package uz.pdp.registrationpage.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second_contact.*
import uz.pdp.registrationpage.R
import uz.pdp.registrationpage.utils.SharedPreferenceContact

class SecondContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_contact)
        SharedPreferenceContact.init(this)
        var contact = SharedPreferenceContact.contact

        textContactList.text = contact


    }
}