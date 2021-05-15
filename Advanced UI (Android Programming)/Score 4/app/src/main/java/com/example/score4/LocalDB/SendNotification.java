package com.example.score4.LocalDB;

import android.content.Context;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.score4.MainActivity;

public class SendNotification {
    private static int notificationId = 9;
    public static void getNotification(Context context, String notificationTitle,String notificationText) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(notificationId, MainActivity.builder.setContentText(MainActivity.date)
                .setContentTitle(notificationTitle)
                .setContentText(notificationText)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(notificationText))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .build());
    }
}
