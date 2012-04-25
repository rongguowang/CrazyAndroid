package org.crazyandroid.adapter;
import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class ClickableButtonActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.clickablebuttonlayout);
    	Button mClickableButton = (Button)findViewById(R.id.clickable);
    	mClickableButton.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				Log.v("--CrazyAndroid--", "mClickableButton onTouchListener");
				return false;
			}
    	});
    }
    
    public boolean onTouchEvent(MotionEvent event) {
    	Log.v("--CrazyAndroid--", "onTouchEvent in ClickabelButtonActivity");
    	return false;
    }
}
