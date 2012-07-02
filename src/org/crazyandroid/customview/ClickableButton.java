package org.crazyandroid.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;

public class ClickableButton extends Button{

	public ClickableButton(Context context, AttributeSet set) {
		super(context, set);
	}
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	super.onKeyDown(keyCode, event);
    	Log.v("--CrazyAndroid--", "the onKeyDown in ClickableButton");
    	
    	return true;
    }
    
    public boolean onTouchEvent(MotionEvent event) {
    	super.onTouchEvent(event);
    	Log.v("--CrazyAndroid--", "the onTouchEvent in ClickableButton");
    	return false;
    }
}
