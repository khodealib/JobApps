package com.example.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.apps.jobapps.R;
import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationReceivedResult;
import com.apps.jobapps.Splash_Activity;


public class NotificationExtenderExample extends NotificationExtenderService {
	
	public static final int NOTIFICATION_ID = 1;
	private NotificationManager mNotificationManager;
	
   @Override
   protected boolean onNotificationProcessing(OSNotificationReceivedResult receivedResult) {

	   String title = receivedResult.payload.title;
	   String message = receivedResult.payload.body;
	   sendNotification(title,message);
	   
      return true;
   }
   
   private void sendNotification(String title, String msg) {
		mNotificationManager = (NotificationManager)
				this.getSystemService(Context.NOTIFICATION_SERVICE);
		    		
   		 PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                    new Intent(this, Splash_Activity.class), 0);
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
            .setAutoCancel(true)
            .setContentText(msg)
            .setSmallIcon(R.drawable.app_icon)
            .setContentText(msg);
            
            if(title.trim().isEmpty()) {
            	mBuilder.setContentTitle(getString(R.string.app_name));
            	mBuilder.setTicker(getString(R.string.app_name));
            } else {
            	mBuilder.setContentTitle(title);
            	mBuilder.setTicker(title);
            }
     
            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
   		
	}

}
