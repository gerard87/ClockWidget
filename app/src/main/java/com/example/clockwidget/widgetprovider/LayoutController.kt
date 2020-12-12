package com.example.clockwidget.widgetprovider

import android.content.SharedPreferences
import com.example.clockwidget.R

const val SHADOW_KEY: String = "shadow"

fun getLayout(sharedPreferences: SharedPreferences): Int =
        if (sharedPreferences.getBoolean(SHADOW_KEY, true))
            R.layout.appwidget_provider_layout_shadows else R.layout.appwidget_provider_layout