package uz.pdp.registrationpage.utils

import androidx.core.content.edit
import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceContact {
    private const val NAME = "contact"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }


    private inline fun SharedPreferences.editor(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var contact: String?
        get() = sharedPreferences.getString("c", "")
        set(value) = SharedPreferenceContact.sharedPreferences.edit() {
            if (value != "") {
                this.putString("c", value)
            }
        }
}