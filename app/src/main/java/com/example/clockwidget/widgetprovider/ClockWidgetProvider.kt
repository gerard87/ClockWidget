package com.example.clockwidget.widgetprovider

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.widget.RemoteViews
import com.example.clockwidget.R

class ClockWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // Perform this loop procedure for each App Widget that belongs to this provider
        appWidgetIds.forEach { appWidgetId ->

            val sharedPreferences: SharedPreferences = context
                .getSharedPreferences("clock", Context.MODE_PRIVATE)

            // Create an Intent to launch ClockActivity
            val clockIntent = context.packageManager
                    .getLaunchIntentForPackage("com.google.android.deskclock")

            val pendingIntent: PendingIntent = clockIntent
                .let { intent ->
                    PendingIntent.getActivity(context, 0, intent, 0)
                }

            // Get the layout for the App Widget
            val views: RemoteViews = RemoteViews(
                context.packageName,
                R.layout.appwidget_provider_layout
            ).apply {
                setOnClickPendingIntent(R.id.clock, pendingIntent)
                val color = if (sharedPreferences.getBoolean("color", false)) Color.BLACK else Color.WHITE
                setTextColor(R.id.clock, color)
            }

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)

        if (context != null) {
            val appWidgetManager: AppWidgetManager = AppWidgetManager.getInstance(context)
            val componentName = ComponentName(context.packageName, ClockWidgetProvider::class.java.name)
            onUpdate(context, appWidgetManager, appWidgetManager.getAppWidgetIds(componentName))
        }
    }

}