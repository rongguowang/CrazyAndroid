package org.crazyandroid.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;

public class ColorLightsActivity extends Activity{
	int currentColor = 0;
	
	final int[] colors = new int[]{
			R.color.red,
			R.color.pink,
			R.color.green,
			R.color.blue,
			R.color.yellow,
			R.color.orange,
			R.color.purple};
	
	final int[] names = new int[]{R.id.view01,
			R.id.view02,
			R.id.view03,
			R.id.view04,
			R.id.view05,
			R.id.view06,
			R.id.view07};
	TextView[] views = new TextView[7];
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	setContentView(R.layout.colorlights);
    	
    	for(int i = 0; i < 7; i++){
    		views[i] = (TextView)findViewById(names[i]);
    	}
    	
    	final Handler handler = new Handler() {
    		public void handleMessage(Message msg) {
    			if(msg.what == 0x2222){
    				/* the color moves from right to left.
    				for(int i = 0; i < 7 - currentColor; i++) {
    					views[i].setBackgroundResource(colors[i + currentColor]);
    				}
    				for(int i = 0, j = 7 - currentColor; j < 7; i++, j++){
    					views[j].setBackgroundResource(colors[i]);
    				}*/
    				
    				for(int i = 0; i < currentColor; i++) {
    					views[i].setBackgroundResource(colors[7 - currentColor + i]);
    				}
    				
    				for(int i = 0; i  + currentColor < 7; i++) {
    					views[i + currentColor].setBackgroundResource(colors[i]);
    				}
    			}
    			currentColor++;
    			super.handleMessage(msg);
    		}
    	};
    	
    	new Timer().schedule(new TimerTask() {
    		public void run() {
    			if(currentColor >= 6) {
    				currentColor = 0;
    			}
    			Message msg = new Message();
    			msg.what = 0x2222;
    			
    			handler.sendMessage(msg);
    		}
    	}, 0, 500);
    }
}
