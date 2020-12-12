package uz.pdp.registrationpage.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object SharedPreferenceSwitch {
    private const val NAME = "switch"
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

    var switch: Boolean?
        get() = sharedPreferences.getBoolean("s", false)
        set(value) = SharedPreferenceSwitch.sharedPreferences.edit() {
            if (value != null) {
                this.putBoolean("s", value)
            }
        }
}