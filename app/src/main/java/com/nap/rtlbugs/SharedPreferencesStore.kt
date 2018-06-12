package com.nap.rtlbugs

import android.content.Context.MODE_PRIVATE
import android.content.Context
import android.R.id.edit
import android.content.SharedPreferences

object SharedPreferencesStore {

    private const val PREFERENCES_NAME = "test_app_preferences"

    const val LOCALE_PREFERENCE = "LOCALE"
    const val ENGLISH_LOCALE = "en"
    const val ARABIC_LOCALE = "ar"

    fun saveString(context: Context, key: String, value: String) {
        val editor = context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit()
        editor.putString(key, value)
        editor.commit()
    }


    fun getString(context: Context, key: String, default: String = ""): String {
        val sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)
        return sharedPreferences.getString(key, default)
    }
}