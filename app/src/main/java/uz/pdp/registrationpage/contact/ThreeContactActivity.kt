package uz.pdp.registrationpage.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sdsmdg.tastytoast.TastyToast
import kotlinx.android.synthetic.main.activity_three_contact.*
import uz.pdp.registrationpage.R
import uz.pdp.registrationpage.model.Contact
import uz.pdp.registrationpage.utils.SharedPreferenceContact

class ThreeContactActivity : AppCompatActivity() {
    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_contact)
        SharedPreferenceContact.init(this)
        gson = Gson()

        addContact.setOnClickListener {
            var name = contactName.text.toString()
            var number = contactNumber.text.toString()
            var contactList = arrayListOf<Contact>()
            var contact1 = SharedPreferenceContact.contact
            var contact = Contact(name, number)

            if (contact1 != "") {
                val typeJson = object : TypeToken<List<Contact>>() {}.type
                val fromJsonListContact = gson.fromJson<List<Contact>>(contact1, typeJson)

                contactList.addAll(fromJsonListContact)
                contactList.add(contact)

                val toJsonUser = gson.toJson(contactList)
                SharedPreferenceContact.contact = toJsonUser


            } else {
                contactList.add(contact)
                val toJsonUser = gson.toJson(contactList)
                SharedPreferenceContact.contact = toJsonUser
            }

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(number)) {
                var intent = Intent(this, SecondContactActivity::class.java)
                intent.putExtra("contact1", name)
                intent.putExtra("contact2", number)
                startActivity(intent)
                contactName.setText("")
                contactNumber.setText("")
                TastyToast.makeText(
                    this,
                    "Contact saqlandi",
                    TastyToast.LENGTH_LONG,
                    TastyToast.SUCCESS
                ).show()

            } else {
                TastyToast.makeText(
                    this,
                    "Raqam yoki ism kiritilmadi",
                    TastyToast.LENGTH_LONG,
                    TastyToast.ERROR
                ).show()
            }


        }
    }
}