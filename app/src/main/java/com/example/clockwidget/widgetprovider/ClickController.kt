package com.example.clockwidget.widgetprovider

import android.app.PendingIntent
import android.content.Context
import android.content.Intent

const val CLICK_PACKAGE: String = "com.google.android.deskclock"

private fun getOpenIntent(context: Context): Intent? =
        context.packageManager.getLaunchIntentForPackage(CLICK_PACKAGE)

fun getPendingIntent(context: Context) : PendingIntent {
    // Create an Intent to launch OpenActivity
    return getOpenIntent(context).let { intent ->
        PendingIntent.getActivity(context, 0, intent, 0)
    }
}