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
    }
}
