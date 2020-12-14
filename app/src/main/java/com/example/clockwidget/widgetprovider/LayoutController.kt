package com.example.clockwidget.widgetprovider

import android.content.SharedPreferences
import com.example.clockwidget.R

const val SHADOW_KEY: String = "shadow"
const val FONT_KEY: String = "font"

fun getLayout(sharedPreferences: SharedPreferences): Int {
    val shadow: Boolean = sharedPreferences.getBoolean(SHADOW_KEY, true)
    val font: String = sharedPreferences.getString(FONT_KEY, "0").toString()

    return if (shadow) {
        when (font) {
            "0" -> R.layout.appwidget_provider_layout_google_sans_shadows
            "1" -> R.layout.appwidget_provider_layout_open_sans_shadows
            "2" -> R.layout.appwidget_provider_layout_montserrat_shadows
            else -> R.layout.appwidget_provider_layout_google_sans_shadows
        }
    } else {
        when (font) {
            "0" -> R.layout.appwidget_provider_layout_google_sans
            "1" -> R.layout.appwidget_provider_layout_open_sans
            "2" -> R.layout.appwidget_provider_layout_montserrat
            else -> R.layout.appwidget_provider_layout_google_sans
        }
    }
}