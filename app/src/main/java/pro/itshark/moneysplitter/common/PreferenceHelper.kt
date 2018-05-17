package pro.itshark.moneysplitter.common

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import pro.itshark.moneysplitter.EMPTY_STRING

object PreferenceHelper {

    fun defaultSharedPreferences(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    fun customSharedPreferences(context: Context, name: String) =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()

        operation(editor)
        editor.apply()
    }

    operator fun SharedPreferences.set(key: String, value: Any?) = when (value) {
        is String? -> edit({ it.putString(key, value) })
        is Int -> edit { it.putInt(key, value) }
        is Long -> edit { it.putLong(key, value) }
        is Float -> edit { it.putFloat(key, value) }
        is Boolean -> edit { it.putBoolean(key, value) }
        else -> throw UnsupportedOperationException("Unsupported data type")
    }

    inline operator fun <reified T : Any> SharedPreferences.get(key: String, defValue: T? = null): T = when (T::class) {
        String::class -> getString(key, defValue as? String ?: EMPTY_STRING) as T
        Int::class -> getInt(key, defValue as? Int ?: 0) as T
        Long::class -> getLong(key, defValue as? Long ?: 0) as T
        Float::class -> getFloat(key, defValue as? Float ?: 0F) as T
        Boolean::class -> getBoolean(key, defValue as? Boolean ?: false) as T
        else -> throw UnsupportedOperationException("Unsupported data type")
    }
}
