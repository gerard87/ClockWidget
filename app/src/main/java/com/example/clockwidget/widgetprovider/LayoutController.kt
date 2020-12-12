package com.example.clockwidget.widgetprovider

import android.content.SharedPreferences
import com.example.clockwidget.R

fun getLayout(sharedPreferences: SharedPreferences): Int =
        if (sharedPreferences.getBoolean("shadow", true))
            R.layout.appwidget_provider_layout_shadows else R.layout.appwidget_provider_layout