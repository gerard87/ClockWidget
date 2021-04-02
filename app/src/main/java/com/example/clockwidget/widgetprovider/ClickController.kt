package com.example.clockwidget.widgetprovider

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

private fun getOpenIntent(context: Context): Intent? {
    val apps: MutableList<ApplicationInfo> =
        context.packageManager?.getInstalledApplications(PackageManager.GET_META_DATA) as MutableList<ApplicationInfo>
    var pck: String = "com.google.android.deskclock"
    for (app in apps) {
        if (app.packageName.contains("deskclock")) pck = app.packageName
    }
    return context.packageManager.getLaunchIntentForPackage(pck)
}

fun getPendingIntent(context: Context) : PendingIntent {
    // Create an Intent to launch OpenActivity
    return getOpenIntent(context).let { intent ->
        PendingIntent.getActivity(context, 0, intent, 0)
    }
}