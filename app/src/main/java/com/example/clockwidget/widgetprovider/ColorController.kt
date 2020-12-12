package com.example.clockwidget.widgetprovider

import android.content.SharedPreferences
import android.graphics.Color

const val COLOR_KEY = "color"

fun getColor(sharedPreferences: SharedPreferences): Int =
        if (sharedPreferences.getString(COLOR_KEY, "0").toString() == "0")
            Color.WHITE else Color.BLACK