package org.crazyandroid.basic;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;

public class ToggleButtonActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.togglebutton);
    	
    	final LinearLayout mTestLinear = (LinearLayout)findViewById(R.id.testlinearlayout);
    	ToggleButton mToggleButton = (ToggleButton)findViewById(R.id.togglebutton);
    	mToggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
    		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
    			if(arg1) {
    				mTestLinear.setOrientation(1);
    			} else {
    				mTestLinear.setOrientation(0);
    			}
    		}
    	});
    }
}
