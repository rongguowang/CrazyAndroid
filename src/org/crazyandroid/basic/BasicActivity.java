package org.crazyandroid.basic;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.View;

public class BasicActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.basiclayout);
    	
    	Button mTextView = (Button)findViewById(R.id.textview);
    	mTextView.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, TextViewActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mLogin = (Button)findViewById(R.id.login);
    	mLogin.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, LogInActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mImageButton = (Button)findViewById(R.id.imagebutton);
    	mImageButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, ImageButtonActivity.class);
    			startActivity(intent);
    		}
    	});
    	Button mPatch9Button = (Button)findViewById(R.id.patch9_button);
    	mPatch9Button.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, Patch9Activity.class);
    			startActivity(intent);
    		}
    	});
    	Button mRadioCheckButton = (Button)findViewById(R.id.radio_check_button);
    	mRadioCheckButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, RadioCheckActivity.class);
    			startActivity(intent);
    		}
    	});
    	Button mToggleButton = (Button)findViewById(R.id.toggle_button);
    	mToggleButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, ToggleButtonActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mClockButton = (Button)findViewById(R.id.clock_button);
    	mClockButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, ClockActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mImageButton2 = (Button)findViewById(R.id.image_button);
    	mImageButton2.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, ImageActivity.class);
    			startActivity(intent);
    		}
    	});
    }
}
