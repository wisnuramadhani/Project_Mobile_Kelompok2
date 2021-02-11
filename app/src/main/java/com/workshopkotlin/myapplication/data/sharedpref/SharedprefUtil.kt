package com.workshopkotlin.myapplication.data.sharedpref

import android.content.Context
import android.content.SharedPreferences

class SharedprefUtil {

    companion object {

        private var sharedPreferences: SharedPreferences? = null
        private var editor: SharedPreferences.Editor? = null
        private val sharedPrefName = "com.workshopkotlin.anggitprayogo.sharedpref"

        private val isLogginKey = "isLogginKey"
        private val nameUserKey = "nameUser"
        private val emailUserKey = "emailUser"
        private val idUserKey = "idUser"

        fun init(context: Context) {
            if (sharedPreferences == null) {
                sharedPreferences = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
                    .apply { editor = edit() }
            }
        }

        var isLoggin: Boolean?
            get() = sharedPreferences?.getBoolean(isLogginKey, false)
            set(value) {
                value?.let { editor?.putBoolean(isLogginKey, it)?.apply() }
            }

        var nameUser: String?
            get() = sharedPreferences?.getString(nameUserKey, "")
            set(value) {
                editor?.putString(nameUserKey, value)?.apply()
            }

        var emailUser: String?
            get() = sharedPreferences?.getString(emailUserKey, "")
            set(value) {
                editor?.putString(emailUserKey, value)?.apply()
            }

        var idUser: Long?
            get() = sharedPreferences?.getLong(idUserKey, 0)
            set(value) {
                value?.let { editor?.putLong(idUserKey, it)?.apply() }
            }

        fun clearSharedPref() {
            with(editor) {
                this?.remove(isLogginKey)?.apply()
                this?.remove(nameUserKey)?.apply()
                this?.remove(emailUserKey)?.apply()
            }
        }
    }
}