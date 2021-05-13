package com.example.score4.RemoteDB;

import android.content.Context;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.score4.MainActivity;

import java.util.Map;

import static android.content.ContentValues.TAG;

public class MatchNotification {
    private static String notificationText = "Sports:";
    private static boolean matchesToday = false;
    private static int notificationId = 5;
    public static void getNotification(Context context) {
        for (Map<String, Object> i: MainActivity.Basketball) {
            Log.d(TAG, "date: " +MainActivity.date+ "i:" + i.get("date"));
            if (i.get("date").equals(MainActivity.date)) {
                notificationText += "\nBasketball";
                matchesToday = true;
                break;
            }
        }
        for (Map<String, Object> i: MainActivity.Boxing) {
            if (i.get("date").equals(MainActivity.date)) {
                notificationText += "\nBoxing";
                matchesToday = true;
                break;
            }
        }
        for (Map<String, Object> i: MainActivity.Football) {
            if (i.get("date").equals(MainActivity.date)) {
                notificationText += "\nFootball";
                matchesToday = true;
                break;
            }
        }
        for (Map<String, Object> i: MainActivity.Volleyball) {
            if (i.get("date").equals(MainActivity.date)) {
                notificationText += "\nVolleyball";
                matchesToday = true;
                break;
            }
        }
        for (Map<String, Object> i: MainActivity.Wrestling) {
            if (i.get("date").equals(MainActivity.date)) {
                notificationText += "\nWrestling";
                matchesToday = true;
                break;
            }
        }

        if (matchesToday) {
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
            notificationManager.notify(notificationId, MainActivity.builder.setContentText(MainActivity.date)
                    .setContentTitle("There are matches scheduled for today!")
                    .setContentText(notificationText)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(notificationText))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build());
        } else {
            Log.d(TAG,"no matches today");
            return;
        }
    }
}
