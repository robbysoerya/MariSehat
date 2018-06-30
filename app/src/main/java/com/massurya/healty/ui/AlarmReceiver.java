package com.massurya.healty.ui;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;

import com.massurya.healty.R;

public class AlarmReceiver
        extends BroadcastReceiver
{
    public void onReceive(Context context, Intent intent)
    {
        Intent localIntent = context.getPackageManager().getLaunchIntentForPackage("com.massurya.healty");
        localIntent.addCategory("android.intent.category.LAUNCHER");
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.png_icons8drinking50826)
                .setContentTitle("Pengingat Minum Air")
                .setContentText("Jangan Lupa Untuk Minum Air Putih")
                .setContentIntent(PendingIntent.getActivity(context, 0, localIntent, 0))
                .setAutoCancel(true)
                .setVibrate(new long[] { 500, 500, 500, 500, 500, 500, 500, 500, 500 });
        NotificationManager mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(001, mBuilder.build());
    }
}


/* Location:              /home/robbysoerya/Documents/dex2jar-2.1-SNAPSHOT/classes-dex2jar.jar!/com/massurya/healty/ui/AlarmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */