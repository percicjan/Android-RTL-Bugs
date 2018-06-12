package com.nap.rtlbugs

import android.content.Context
import android.content.Intent.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nap.rtlbugs.SharedPreferencesStore.ARABIC_LOCALE
import com.nap.rtlbugs.SharedPreferencesStore.ENGLISH_LOCALE
import com.nap.rtlbugs.SharedPreferencesStore.LOCALE_PREFERENCE
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        languageTextView.text = SharedPreferencesStore.getString(applicationContext, LOCALE_PREFERENCE, ENGLISH_LOCALE)

        bug3recyclerview.addItemDecoration(TagItemSpacingDecoration(this))
        bug3recyclerview.adapter = TagAdapter()
    }


    override fun attachBaseContext(newBase: Context?) {
        val localeStr = SharedPreferencesStore.getString(newBase!!, LOCALE_PREFERENCE, ENGLISH_LOCALE)
        val locale = Locale(localeStr)
        val context = AppContextWrapper.wrap(newBase, locale)
        CustomApplication.updateConfiguration(locale)
        super.attachBaseContext(context)
    }


    override fun onResume() {
        super.onResume()

        changeLanguageButton.setOnClickListener {
            val currentLocale = SharedPreferencesStore.getString(applicationContext, LOCALE_PREFERENCE, ENGLISH_LOCALE)
            val newLocale = if (currentLocale == ENGLISH_LOCALE) {
                ARABIC_LOCALE
            } else {
                ENGLISH_LOCALE
            }
            changeLocale(newLocale)
        }
    }


    private fun changeLocale(newLocale: String) {
        CustomApplication.updateConfiguration(Locale(newLocale))

        SharedPreferencesStore.saveString(applicationContext, LOCALE_PREFERENCE, newLocale)

        val landingIntent = applicationContext.packageManager.getLaunchIntentForPackage(applicationContext.packageName)
        landingIntent.addFlags(FLAG_ACTIVITY_CLEAR_TOP or FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(landingIntent)
        finish()
    }



}
