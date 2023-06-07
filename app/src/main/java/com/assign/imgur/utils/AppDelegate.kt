package com.assign.imgur.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class AppDelegate : Application() {

    companion object {
        private const val PREFS_NAME = "MyPrefs"
        private const val KEY_CLIENT_ID = "clientID"

        private lateinit var instance: AppDelegate

        fun getInstance(): AppDelegate {
            return instance
        }
    }

    private lateinit var sharedPreferences: SharedPreferences

    var clientID: String? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        clientID = sharedPreferences.getString(KEY_CLIENT_ID, null)
    }

    fun saveBearerToken(token: String) {
        clientID = token

        val editor = sharedPreferences.edit()
        editor.putString(KEY_CLIENT_ID, token)
        editor.apply()
    }
}