package uz.pdp.registrationpage.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sdsmdg.tastytoast.TastyToast
import kotlinx.android.synthetic.main.activity_login_first.*
import uz.pdp.registrationpage.R
import uz.pdp.registrationpage.model.User
import uz.pdp.registrationpage.utils.SharedPreferenceUI

class LoginFirstActivity : AppCompatActivity() {
    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_first)
        SharedPreferenceUI.init(this)
        gson = Gson()


        signButton.setOnClickListener {
            val users = SharedPreferenceUI.user
            val userName = name1.text.toString()
            val password = password1.text.toString()

            if (users != "") {

                val typeJson = object : TypeToken<List<User>>() {}.type
                val fromJsonListUser = gson.fromJson<List<User>>(users, typeJson)

                for (list in fromJsonListUser) {
                    if (list.userName.trim().equals(userName.trim(), ignoreCase = true)
                        && list.userPassword.trim()
                            .equals(password.trim(), ignoreCase = true)
                    ) {

                        val intent = Intent(this, LoginThreeActivity::class.java)
                        intent.putExtra("a", userName)
                        intent.putExtra("b", password)
                        startActivity(intent)
                        TastyToast.makeText(
                            this,
                            "Tizimga xush kelibsiz",
                            TastyToast.LENGTH_LONG,
                            TastyToast.ERROR
                        ).show()
                        name1.setText("")
                        password1.setText("")

//                        startActivity(Intent(this, LoginThreeActivity::class.java))
                    }
                }
                if (!users.equals(userName) && !users.equals(password)) {
                    TastyToast.makeText(
                        this,
                        "Login yoki parol xato!!!",
                        TastyToast.LENGTH_LONG,
                        TastyToast.ERROR
                    ).show()
                }


//                var fromJsonUsers = gson.fromJson(users, User::class.java)
//                if (fromJsonUsers.userName == userName
//                    && fromJsonUsers.userPassword == password
//                ) {
//                    startActivity(Intent(this, LoginThreeActivity::class.java))
//                } else {
//                    TastyToast.makeText(
//                        this,
//                        "Login yoki parol xato!!!",
//                        TastyToast.LENGTH_LONG,
//                        TastyToast.ERROR
//                    ).show()
//                }

            }

        }


        googleBtn.setOnClickListener {
            startActivity(Intent(this, LoginSecondActivity::class.java))
        }
        facebookBtn.setOnClickListener {
            startActivity(Intent(this, LoginSecondActivity::class.java))
        }
        twitterBtn.setOnClickListener {
            startActivity(Intent(this, LoginSecondActivity::class.java))
        }

    }
}