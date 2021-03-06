package com.lalosoft.myshopping

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class App : Application() {

    companion object {
        private var INSTANCE : App? = null
        fun get() : App {
            return INSTANCE!!
        }
    }

    val MY_SHOPPING_PREFERENCES = "MyShopping.preferences"
    val PREF_REMEMBER_LOGIN = "pref.remember.login"
    val PREF_TOKEN = "pref.token"

    var rememberLogin: Boolean
        set(value) = updateBooleanPreference(PREF_REMEMBER_LOGIN, value)
        get() = getBooleanPref(PREF_REMEMBER_LOGIN)

    var token: String
        set(value) = updateStringPreference(PREF_TOKEN, value)
        get() = getStringPref(PREF_TOKEN)

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    private fun updateBooleanPreference(preferenceName: String, value: Boolean) {
        getSP().edit().putBoolean(preferenceName, value).apply()
    }

    private fun updateStringPreference(prefName: String, value: String) {
        getSP().edit().putString(prefName, value).apply()
    }

    private fun getBooleanPref(prefName: String) : Boolean {
        return getSP().getBoolean(prefName, false)
    }

    private fun getStringPref(prefName: String) : String {
        return getSP().getString(prefName, "")
    }

    private fun getSP() : SharedPreferences {
        return getSharedPreferences(MY_SHOPPING_PREFERENCES, Context.MODE_PRIVATE)
    }

}