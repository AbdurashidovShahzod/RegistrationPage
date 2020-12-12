package uz.pdp.registrationpage.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object SharedPreferenceUI {

    private const val NAME = "login"
    private const val MODE = Context.MODE_PRIVATE
    lateinit var sharedPreferences: SharedPreferences


    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.editor(operator: (SharedPreferences.Editor) -> Unit) {
        var editor = edit()
        operator(editor)
        editor.apply()
    }

    var user: String?
        get() = sharedPreferences.getString("ui", "")
        set(value) = SharedPreferenceUI.sharedPreferences.edit() {
            if (value != null) {
                this.putString("ui", value)
            }
        }



    var switch: Boolean?
        get() = SharedPreferenceSwitch.sharedPreferences.getBoolean("s", false)
        set(value) = SharedPreferenceUI.sharedPreferences.edit() {
            if (value != null) {
                this.putBoolean("s", value)
            }
        }
}