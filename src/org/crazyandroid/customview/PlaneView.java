package org.crazyandroid.customview;

import org.crazyandroid.sample.R;

import android.view.View;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
public class PlaneView extends View{
    public float mCurrentX;
    public float mCurrentY;
    Bitmap mPlane;
    
    public PlaneView(Context context) {
    	super(context);
    	mPlane = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
    	setFocusable(true);
    }
    
    public void onDraw(Canvas canvas) {
    	super.onDraw(canvas);
    	Paint p = new Paint();
    	canvas.drawBitmap(mPlane, mCurrentX, mCurrentY, p);
    }
}
