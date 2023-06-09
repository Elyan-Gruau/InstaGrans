package edu.mj102660.instagrans;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import edu.mj102660.instagrans.ui.news.NewsFragment;

public class NotificationBuilder {

    private Activity activity;

    public NotificationBuilder(Activity activity) {
        this.activity = activity;
    }

    public void buildNotification(String title, String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity, "Test Channel")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(activity);
        if (ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        managerCompat.notify(1, builder.build());
    }
}
