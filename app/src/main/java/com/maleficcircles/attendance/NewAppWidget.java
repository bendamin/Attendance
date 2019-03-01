package com.maleficcircles.attendance;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        String Monday[] = {"Data Communications\nKevin Street - 4th Floor","Object Oriented Programming\nKevin Street - 4th Floor"};
        String MondayTimes[] = {"10:00\n11:00", "11:00\n13:00"};
        int mon[] = {10,11};

        String Tuesday[] = {"Legal And Professional Issues\nKevin Street - 4th Floor","Legal And Professional Issues\nKevin Street\n1st Floor","Data Communications\nKevin Street - Ground Floor"};
        String TuesdayTimes[] = {"12:00\n13:00","13:00\n14:00","16:00\n17:00"};
        int tue[] = {12,13,16};

        String Wednesday[] = {"Legal And Professional Issues\nKevin Street - 4th Floor","Software Engineering 2\nKevin Street - 2nd Floor","Software Engineering 2\nAnnex Building - 1st Floor","Object Oriented Programming\nAnnex Building - 1st Floor"};
        String WednesdayTimes[] = {"10:00\n11:00","12:00\n14:00","15:00\n16:00","16:00\n18:00"};
        int wed[] = {10,12,13,16};

        String Thursday[] = {"Object Oriented Programming\nnKevin Street - 4th Floor","Human Computer Interaction\nKevin Street - 4th Floor","Data Communication\nKevin Street - 3rd Floor","Internship Program\nKevin Street - 4th Floor","Human Computer Interaction\nAungier Street - 1st Floor"};
        String ThursdayTime[] = {"09:00\n10:00","10:00\n11:00","11:00\n12:00\n","13:00\n14:00","14:00\n16:00"};
        int thu[] = {9,10,11,13,14};

        String Friday[] = {"Algorithms And Data Structures\nAnnex Building - 3rd Floor","Human Computer Interaction\nKevin Street - 2nd Floor","Data Communications\nKevin Street - 2nd Floor","Algorithms And Data Structures\nKevin Street - 2nd Floor","Algorithms And Data Structures\nKevin Street - 1st Floor","Algorithms And Data Structures\nKevin Street - 1st Floor"};
        String FridayTime[] = {"09:00\n10:00","10:00\n11:00","11:00\n12:00","12:00\n13:00","14:00\n15:00","15:00\n16:00"};
        int fri[] = {9,10,11,12,14,15};

        Calendar rightNow;
        rightNow = Calendar.getInstance();
        int hour;
        hour = rightNow.get(Calendar.HOUR_OF_DAY);

        String time;
        time = String.valueOf(hour);
        int j;
        j= 0;
        int i;

        int day;
        day = rightNow.get(Calendar.DAY_OF_WEEK);

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);
        CharSequence classname;
        CharSequence classtime;

        switch (day) {
            case Calendar.MONDAY:
                // Current day is Monday
                if(hour<mon[mon.length - 1]) {
                    for (i = mon.length - 1; i > 0; i--) {
                        if (hour < mon[i]) {
                            if (hour >= mon[i - 1]) {
                                j = i;
                            }
                        }
                    }
                    classname = Monday[j];
                    views.setTextViewText(R.id.appwidget_text, classname);
                    classtime = MondayTimes[j];
                    views.setTextViewText(R.id.appwidget_time, classtime);
                }else{
                    classname = Tuesday[j];
                    views.setTextViewText(R.id.appwidget_text,classname);
                    classtime = TuesdayTimes[j];
                    views.setTextViewText(R.id.appwidget_time,classtime);
                }
                break;
            case Calendar.TUESDAY:
                // etc.
                if(hour<tue[tue.length - 1]) {
                    for(i=tue.length-1; i > 0; i--){
                        if(hour < tue[i])      {
                            if (hour>=tue[i-1]){
                                j = i;
                            }
                        }
                    }
                    classname = Tuesday[j];
                    views.setTextViewText(R.id.appwidget_text,classname);
                    classtime = TuesdayTimes[j];
                    views.setTextViewText(R.id.appwidget_time,classtime);
                }else{
                    classname = Wednesday[j];
                    views.setTextViewText(R.id.appwidget_text,classname);
                    classtime = WednesdayTimes[j];
                    views.setTextViewText(R.id.appwidget_time,classtime);
                }
                break;
            case Calendar.WEDNESDAY:
                // etc.
                if(hour<wed[wed.length - 1]) {
                    for(i=wed.length-1; i > 0; i--){
                        if(hour < wed[i])      {
                            if (hour>=wed[i-1]){
                                j = i;
                            }
                        }
                    }
                    classname = Wednesday[j];
                    views.setTextViewText(R.id.appwidget_text,classname);
                    classtime = WednesdayTimes[j];
                    views.setTextViewText(R.id.appwidget_time,classtime);
                }else{
                    classname = Thursday[j];
                    views.setTextViewText(R.id.appwidget_text,classname);
                    classtime = ThursdayTime[j];
                    views.setTextViewText(R.id.appwidget_time,classtime);
                }
                break;
            case Calendar.THURSDAY:
                // etc.
                if(hour<thu[thu.length - 1]) {
                    for(i=thu.length-1; i > 0; i--){
                        if(hour < thu[i])      {
                            if (hour>=thu[i-1]){
                                j = i;
                            }
                        }
                    }
                    classname = Thursday[j];
                    views.setTextViewText(R.id.appwidget_text,classname);
                    classtime = ThursdayTime[j];
                    views.setTextViewText(R.id.appwidget_time,classtime);
                }else{
                    classname = Friday[j];
                    views.setTextViewText(R.id.appwidget_text,classname);
                    classtime = FridayTime[j];
                    views.setTextViewText(R.id.appwidget_time,classtime);
                }

                break;
            case Calendar.FRIDAY:
                // Current day is Monday
                if(hour<fri[fri.length - 1]) {
                    for (i = fri.length - 1; i > 0; i--) {
                        if (hour < fri[i]) {
                            if (hour >= fri[i - 1]) {
                                j = i;
                            }
                        }
                    }
                    classname = Friday[j];
                    views.setTextViewText(R.id.appwidget_text, classname);
                    classtime = FridayTime[j];
                    views.setTextViewText(R.id.appwidget_time, classtime);
                }else{
                        classname = Monday[j];
                        views.setTextViewText(R.id.appwidget_text,classname);
                        classtime = MondayTimes[j];
                        views.setTextViewText(R.id.appwidget_time,classtime);
                    }
                break;
            default:
                classname = Monday[0];
                views.setTextViewText(R.id.appwidget_text,classname);
                classtime = MondayTimes[0];
                views.setTextViewText(R.id.appwidget_time,classtime);
                break;
        }

//Create an Intent with the AppWidgetManager.ACTION_APPWIDGET_UPDATE action//

        Intent intentUpdate = new Intent(context, NewAppWidget.class);
        intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

//Update the current widget instance only, by creating an array that contains the widget’s unique ID//

        int[] idArray = new int[]{appWidgetId};
        intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);

//Wrap the intent as a PendingIntent, using PendingIntent.getBroadcast()//

        PendingIntent pendingUpdate = PendingIntent.getBroadcast(
                context, appWidgetId, intentUpdate,
                PendingIntent.FLAG_UPDATE_CURRENT);

//Send the pending intent in response to the user tapping the ‘Update’ TextView//

        views.setOnClickPendingIntent(R.id.update, pendingUpdate);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(1, pendingIntent);



        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    public void Monday() {

    }
}

