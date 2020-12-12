package uz.pdp.registrationpage.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sdsmdg.tastytoast.TastyToast
import kotlinx.android.synthetic.main.activity_login_second.*
import uz.pdp.registrationpage.R
import uz.pdp.registrationpage.model.User
import uz.pdp.registrationpage.utils.SharedPreferenceUI

class LoginSecondActivity : AppCompatActivity() {

    private lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_second)
        SharedPreferenceUI.init(this)
        gson = Gson()

        signUpButton.setOnClickListener {

            val userName = userName1.text.toString()
            val userPassword = userPassword1.text.toString()

            val userList = arrayListOf<User>()
            val user1 = SharedPreferenceUI.user
            val user = User(userName, userPassword)


            if (user1 != "") {

                val typeJson = object : TypeToken<List<User>>() {}.type
                val fromJsonListUser = gson.fromJson<List<User>>(user1, typeJson)
                userList.addAll(fromJsonListUser)
                userList.add(user)
                val toJsonUser = gson.toJson(userList)
                SharedPreferenceUI.user = toJsonUser

            } else {

                userList.add(user)
                val toJsonUser = gson.toJson(userList)
                SharedPreferenceUI.user = toJsonUser


            }


            /*
            val contactName = edit1.text.toString()     //""
            val contactNumber = edit2.text.toString()

            val contact = Contact(contactName, contactNumber)
            contactList.add(contact)
            contactAdapter.notifyItemInserted(contactList.size)
            val jsonString = gson.toJson(contactList)
            MySharedPreferance.setContacts(jsonString)

             */









            if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userPassword)) {
                startActivity(Intent(this, LoginFirstActivity::class.java))
                TastyToast.makeText(
                    this,
                    "Siz muvaffaqiyatli ro'yxatdan o'tdingiz",
                    TastyToast.LENGTH_LONG,
                    TastyToast.SUCCESS
                ).show()
                finish()

            } else {
                TastyToast.makeText(
                    this,
                    "Login yoki parol kiritilmadi!!!",
                    TastyToast.LENGTH_LONG,
                    TastyToast.ERROR
                ).show()
            }

        }
    }
}