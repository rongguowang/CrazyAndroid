package org.crazyandroid.adapter;

import java.util.Timer;
import java.util.TimerTask;

import org.crazyandroid.sample.R;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.os.Handler;
import android.os.Message;

public class HandlerActivity extends Activity {
    int[] imageIds = new int[]{
    	R.drawable.java,
    	R.drawable.ee,
    	R.drawable.ajax,
    	R.drawable.xml,
    	R.drawable.classic,
    };
    
    int currentImageId = 0;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagelayout);
		final ImageView show = (ImageView)findViewById(R.id.image1);
		final Handler mHandler = new Handler() {
			public void handleMessage(Message msg) {
				if (msg.what == 0x1233) {
					show.setImageResource(imageIds[currentImageId++]);
					if (currentImageId >= 4) {
						currentImageId = 0;
					}
				}
			}
		};
		new Timer().schedule(new TimerTask() {
			public void run() {
				Message msg = new Message();
				msg.what = 0x1233;
				mHandler.sendMessage(msg);
			}
		}, 0, 800);
	}
}
