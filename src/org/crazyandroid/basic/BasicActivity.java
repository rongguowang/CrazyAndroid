package org.crazyandroid.basic;

import org.crazyandroid.sample.R;
import org.crazyandroid.launcher.LauncherListActivity;
import org.crazyandroid.launcher.PreferedQueryActivity;
import org.crazyandroid.launcher.ViewDragActivity;

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

    	Button mScrollButton = (Button)findViewById(R.id.scroll_button);
    	mScrollButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, ScrollViewActivity.class);
    			startActivity(intent);
    		}
    	});

    	Button mExpandableButton = (Button)findViewById(R.id.expandablelist2_button);
    	mExpandableButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, LauncherListActivity.class);
    			startActivity(intent);
    		}
    	});

    	Button mViewdragButton = (Button)findViewById(R.id.viewdrag_button);
    	mViewdragButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(BasicActivity.this, ViewDragActivity.class);
    			startActivity(intent);
    		}
    	});
        Button mPreferedButton = (Button)findViewById(R.id.preferedquery_button);
        mPreferedButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(BasicActivity.this, PreferedQueryActivity.class);
                startActivity(intent);
            }
        });
    }
}
