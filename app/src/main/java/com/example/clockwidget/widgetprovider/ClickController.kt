package com.example.clockwidget.widgetprovider

import android.app.PendingIntent
import android.content.Context
import android.content.Intent

private fun getOpenIntent(context: Context): Intent? =
        context.packageManager.getLaunchIntentForPackage("com.google.android.deskclock")

fun getPendingIntent(context: Context) : PendingIntent {
    // Create an Intent to launch OpenActivity
    return getOpenIntent(context).let { intent ->
        PendingIntent.getActivity(context, 0, intent, 0)
    }
}