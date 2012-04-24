package org.crazyandroid.adapter;

import org.crazyandroid.customview.PlaneView;
import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

public class PlaneActivity extends Activity implements OnGestureListener{
    GestureDetector mGesture;
    PlaneView mPlane = null;
	int mScreenWidth = 0;
	int mScreenHeight = 0;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	
    	mGesture = new GestureDetector(this);
    	
    	mPlane= new PlaneView(this);
    	setContentView(mPlane);
    	mPlane.setLongClickable(true);
    	mPlane.setBackgroundResource(R.drawable.back);
    	WindowManager mWindowManager = this.getWindowManager();
    	Display mDisplay = mWindowManager.getDefaultDisplay();
    	
    	mScreenWidth = mDisplay.getWidth();
    	mScreenHeight = mDisplay.getHeight();
    	
    	mPlane.mCurrentX = mScreenWidth / 2;
    	mPlane.mCurrentY = mScreenHeight - 40;
    	
    	mPlane.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
//				mPlane.mCurrentX = event.getAction();
//				mPlane.mCurrentY = event.getY();
//				mPlane.invalidate();
				
				return mGesture.onTouchEvent(event);
			}
    	});
    	


    }

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
        if((e1.getX() - e2.getX()) > 0 && (Math.abs(velocityX) > 0)){
        	mPlane.mCurrentX -= (e1.getX() - e2.getX());
        } else if((e1.getX() - e2.getX() < 0 && (Math.abs(velocityX) > 0))) {
        	mPlane.mCurrentX += (e2.getX() - e1.getX());
        }
        mPlane.mCurrentY -= 100;
        if(mPlane.mCurrentX <= 0) {
        	mPlane.mCurrentX = 0;
        }else if(mPlane.mCurrentX > mScreenWidth) {
        	mPlane.mCurrentX = mScreenWidth;
        }
        
        if(mPlane.mCurrentY <= 0) {
        	mPlane.mCurrentY = 0;
        }else if(mPlane.mCurrentY > mScreenHeight) {
        	mPlane.mCurrentY = mScreenHeight;
        }
        mPlane.invalidate();
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
}
