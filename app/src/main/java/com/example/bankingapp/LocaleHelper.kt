package com.example.bankingapp

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import java.util.Locale

object LocaleHelper {

    fun setLocale(context: Context, languageCode: String) {
        // Android 13 ve üzeri (API 33+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val locale = Locale(languageCode)
            val appLocale = androidx.core.os.LocaleListCompat.forLanguageTags(locale.toLanguageTag())
            AppCompatDelegate.setApplicationLocales(appLocale)
        } else {
            // Android 12 ve öncesi
            val locale = Locale(languageCode)
            Locale.setDefault(locale)
            val config = Configuration(context.resources.configuration)
            config.setLocale(locale)
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }
    }
}