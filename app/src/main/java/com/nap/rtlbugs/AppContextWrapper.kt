package com.nap.rtlbugs

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList

import java.util.Locale

class AppContextWrapper(base: Context) : android.content.ContextWrapper(base) {
    companion object {


        fun wrap(context: Context, newLocale: Locale): AppContextWrapper {
            return AppContextWrapper(getUpdatedContext(context, newLocale))
        }


        private fun getUpdatedContext(context: Context, newLocale: Locale): Context {
            val res = context.resources
            val configuration = res.configuration

            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                configuration.setLocale(newLocale)

                val localeList = LocaleList(newLocale)
                LocaleList.setDefault(localeList)
                configuration.locales = localeList

                context.createConfigurationContext(configuration)

            } else {
                configuration.setLocale(newLocale)
                context.createConfigurationContext(configuration)
            }
        }
    }
}
