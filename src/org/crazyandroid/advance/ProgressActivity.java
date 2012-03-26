package org.crazyandroid.advance;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

public class ProgressActivity extends Activity{
	private int[] data = new int[100];
	int hasData = 0;
	int status = 0;
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.progresslayout);
    	
    	final ProgressBar bar1 = (ProgressBar)findViewById(R.id.progressBar1);
    	final ProgressBar bar2 = (ProgressBar)findViewById(R.id.progressBar2);
    	
    	final Handler mHandler = new Handler() {
    		public void handleMessage(Message msg) {
    			if(msg.what == 0x111) {
    				bar1.setProgress(status);
    				bar2.setProgress(status);
    			}
    		}
    	};
    	
    	new Thread() {
    		public void run() {
    			while (status < 100) {
    				status = doWork();
    				Message m = new Message();
    				m.what = 0x111;
    				mHandler.sendMessage(m);
    			}
    		}
    	}.start();
    }

	
	public int doWork() {
		data[hasData++] = (int)(Math.random() * 100);
		
		try{
			Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return hasData;
	}
}
