package com.example.clockwidget.widgetprovider

import android.content.Context
import android.content.SharedPreferences
import com.example.clockwidget.R

fun getTextSize (context: Context, sharedPreferences: SharedPreferences) : Float {
    val key: String = context.getString(R.string.size_preference_key)

    val minSize: Int = context.resources.getInteger(R.integer.min_text_size)
    val maxSize: Int = context.resources.getInteger(R.integer.max_text_size)
    val defaultSize: Int = context.resources.getInteger(R.integer.default_text_size)

    val size: Int = sharedPreferences.getInt(key, defaultSize)
    if (size < minSize) return minSize.toFloat()
    if (size > maxSize) return maxSize.toFloat()
    return size.toFloat()
}
