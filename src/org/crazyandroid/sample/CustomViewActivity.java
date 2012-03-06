package org.crazyandroid.sample;

import org.crazyandroid.customview.DrawView;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.view.View.OnTouchListener;
import android.view.View;

public class CustomViewActivity extends Activity{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.genericlinear);
		
		LinearLayout layout = (LinearLayout)findViewById(R.id.generic_linear);
		
		final DrawView draw = new DrawView(this);
		
		draw.setMinimumWidth(300);
		draw.setMinimumHeight(500);
	    draw.setOnTouchListener(new OnTouchListener() {
	    	public boolean onTouch(View arg0, MotionEvent event) {
	    		draw.currentX = event.getX();
	    		draw.currentY = event.getY();
	    		
	    		draw.invalidate();
	    		return true;
	    	}
	    });
	    
	    layout.addView(draw);
	}
}
