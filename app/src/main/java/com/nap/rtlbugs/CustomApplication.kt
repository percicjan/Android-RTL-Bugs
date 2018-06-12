package com.nap.rtlbugs

import android.app.Application
import java.util.*

class CustomApplication: Application() {

    companion object {
        lateinit var instance: CustomApplication

        fun updateConfiguration(locale: Locale) {
            val dm = instance.resources.displayMetrics
            val conf = instance.resources.configuration
            conf.locale = locale
            conf.setLayoutDirection(locale)
            instance.resources.updateConfiguration(conf, dm)
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}