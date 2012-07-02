package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
public class ToastActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.datedialoglayout);
    	final Button mSimpleToast = (Button)findViewById(R.id.datebn);
    	mSimpleToast.setText("Simple Toast");
    	mSimpleToast.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Toast t = Toast.makeText(ToastActivity.this, "simple toast will hang on for a while", Toast.LENGTH_SHORT);
    			t.show();
    		}
    	});
    	
    	final Button mPicToast = (Button)findViewById(R.id.timebn);
    	mPicToast.setText("Picture Toast");
    	mPicToast.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Toast t = Toast.makeText(ToastActivity.this, "Toast with picture", Toast.LENGTH_LONG);
    			t.setGravity(Gravity.CENTER, 0, 0);
    			View toast = t.getView();
    			ImageView image = new ImageView(ToastActivity.this);
    			image.setImageResource(R.drawable.icon);
    			LinearLayout ll = new LinearLayout(ToastActivity.this);
    			ll.addView(image);
    			ll.addView(toast);
    			t.setView(ll);
    			t.show();
    		}
    	});
    }
}
