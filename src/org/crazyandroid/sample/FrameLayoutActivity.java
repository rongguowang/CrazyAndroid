package org.crazyandroid.sample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;
public class FrameLayoutActivity extends Activity{
	public int currentColor = 0;
	
	final int[] color = new int[] 
			{R.color.color1,
			R.color.color2,
			R.color.color3,
			R.color.color4,
			R.color.color5,
			R.color.color6,
			R.color.color7};
	final int[] names= new int[] 
			{R.id.view0,
			R.id.view1,
			R.id.view2,
			R.id.view3,
			R.id.view4,
			R.id.view5,
			R.id.view6};
	TextView[] views = new TextView[7];
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.framelayout);
		
		for(int i = 0; i < 7; i++){
			views[i] = (TextView)findViewById(names[i]);
		}
		
		final Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				if(msg.what == 0x1122) {
					for(int i = 0; i < 7 - currentColor; i++){
						views[i].setBackgroundResource(color[i] + currentColor);
					}
					
					for(int i= 7 - currentColor, j = 0; i < 7 ; i++, j++){
						views[i].setBackgroundResource(color[j]);
					}
				}
				
				super.handleMessage(msg);
			}
		};
		
		new Timer().schedule(new TimerTask() {
			public void run() {
				currentColor++;
				
				if(currentColor >= 6) {
					currentColor = 0;
				}
				
				Message msg = new Message();
				
				msg.what = 0x1122;
				
				handler.sendMessage(msg);
			}
		}, 0, 100);
	}

}
