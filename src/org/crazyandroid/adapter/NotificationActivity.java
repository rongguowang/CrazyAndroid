package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
public class NotificationActivity extends Activity{
	final int NOTIFICATION_ID = 0x123;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.datedialoglayout);
    	final Button mSend = (Button)findViewById(R.id.datebn);
    	final Button mDel = (Button)findViewById(R.id.timebn);
    	mSend.setText("Send Notification");
    	mDel.setText("Del Notification");
    	mSend.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(NotificationActivity.this, ToastActivity.class);
    			PendingIntent pi = PendingIntent.getActivity(NotificationActivity.this, 0, intent, 0);
    			Notification notify = new Notification();
    			notify.icon = R.drawable.notify;
    			notify.tickerText = "Notification of install other app";
    			notify.when = System.currentTimeMillis();
    			notify.defaults = Notification.DEFAULT_SOUND;
    			notify.defaults = Notification.DEFAULT_ALL;
    			notify.setLatestEventInfo(NotificationActivity.this, "Notification", "install ...", pi);
    			
    			NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    			nm.notify(NOTIFICATION_ID, notify);
    		}
    	});
    	
    	mDel.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    			nm.cancel(NOTIFICATION_ID);
    		}
    	});
    }
}
