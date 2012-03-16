package org.crazyandroid.advance;

import org.crazyandroid.sample.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.View;

public class AdvanceActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.advancelayout);
    	
    	Button mAutoButton = (Button)findViewById(R.id.autocomplete_button);
    	mAutoButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdvanceActivity.this, AutocompleteActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mSpinnerButton = (Button)findViewById(R.id.spinner_button);
    	mSpinnerButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdvanceActivity.this, SpinnerActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mTimeDate = (Button)findViewById(R.id.time_date_button);
    	mTimeDate.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdvanceActivity.this, TimeDateActivity.class);
    			startActivity(intent);
    		}
    	});
    }
}
