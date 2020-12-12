package com.example.clockwidget.widgetprovider

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.TypedValue
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
            val sharedPreferences: SharedPreferences = getSharedPrefs(context)
            // Get the layout for the App Widget
            val views: RemoteViews = RemoteViews(
                context.packageName,
                getLayout(sharedPreferences)
            ).apply {
                setOnClickPendingIntent(R.id.clock, getPendingIntent(context))
                setTextColor(R.id.clock, getColor(sharedPreferences))
                setTextViewTextSize(R.id.clock, TypedValue.COMPLEX_UNIT_SP,
                        getTextSize(context, sharedPreferences))
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

    private fun getSharedPrefs(context: Context): SharedPreferences =
            context.getSharedPreferences("clock", Context.MODE_PRIVATE)

}