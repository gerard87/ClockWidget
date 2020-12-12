package com.example.clockwidget.widgetprovider

import android.content.SharedPreferences
import android.graphics.Color

fun getColor(sharedPreferences: SharedPreferences): Int =
        if (sharedPreferences.getString("color", "0").toString() == "0")
            Color.WHITE else Color.BLACK