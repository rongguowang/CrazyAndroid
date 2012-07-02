package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.ProgressDialog;
import android.app.Dialog;
import android.os.Handler;

public class ProgressDialogActivity extends Activity{
	final int PROGRESS_DIALOG = 0x18;
	private int[] data = new int[100];
	int hasData = 0;
	int ProgressStatus = 0;
	ProgressDialog pd ;
	Handler handler;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);
    	final Button mOk = (Button)findViewById(R.id.ok_button);
    	mOk.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(PROGRESS_DIALOG);
			}});
    	 handler = new Handler() {
    		public void handleMessage(Message msg) {
    			if(msg.what == 0x111) {
    				pd.setProgress(ProgressStatus);
    			}
    		}
    	};
    }
    
    public Dialog onCreateDialog(int id, Bundle status) {
    	switch(id) {
    	case PROGRESS_DIALOG:
    		pd = new ProgressDialog(ProgressDialogActivity.this);
    		pd.setMax(100);
    		pd.setTitle("Percentage");
    		pd.setMessage("Progress Completed");
    		pd.setCancelable(false);
    		pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//    		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    		pd.setIndeterminate(false);
    		break;
    	}
    	return pd;
    }
    
    public void onPrepareDialog(int id, Dialog dialog) {
    	super.onPrepareDialog(id, dialog);
    	switch(id) {
    	case PROGRESS_DIALOG:
    		pd.incrementProgressBy(-pd.getProgress());
    		new Thread(){
    			public void run() {
    				while(ProgressStatus < 100) {
    					ProgressStatus = doWork();
    					Message m = new Message();
    					m.what = 0x111;
    					handler.sendMessage(m);
    				}
    				if(ProgressStatus >= 100) {
    					pd.dismiss();
    				}
    			}
    		}.start();
    	}
    }
    
    public int doWork() {
    	data[hasData++] = (int)(Math.random() * 100);
    	try{
    		Thread.sleep(100);
    	}catch(InterruptedException e){
    		e.printStackTrace();
    	}
    	return hasData;
    }
}
