package org.crazyandroid.basic;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.Chronometer;

public class ClockActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	setContentView(R.layout.clocklayout);
    	
    	final Chronometer mChronometer = (Chronometer)findViewById(R.id.chronometer1); 
    	ToggleButton mToggleButton = (ToggleButton)findViewById(R.id.chronometer_toggle_button);
    	mToggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked) {
					mChronometer.setBase(SystemClock.elapsedRealtime());
					mChronometer.start();
				} else {
					mChronometer.stop();
				}
			}
    	});
    }
}
