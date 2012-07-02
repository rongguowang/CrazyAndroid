package org.crazyandroid.basic;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

public class ImageActivity extends Activity {
	int[] mImages = new int[]{R.drawable.lijiang,
	R.drawable.qiao,
	R.drawable.shuangta,
	R.drawable.shui,
	R.drawable.xiangbi};
	private int currentImage = 0;
	private int currentAlpha = 255;
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.imagelayout);
    	
    	final Button mIncreaseButton = (Button)findViewById(R.id.increasealpha);
    	final Button mDecreaseButton = (Button)findViewById(R.id.decreasealpha);
    	final Button mNextButton = (Button)findViewById(R.id.next);
    	final ImageView mImage1 = (ImageView)findViewById(R.id.image1);
    	final ImageView mImage2 = (ImageView)findViewById(R.id.image2);

    	mNextButton.setOnClickListener( new OnClickListener() {
    		public void onClick(View v) {
    			currentImage++;
    			if(currentImage > 4) {
    				currentImage = 0;
    			}
//    			mImage1.setBackgroundResource(mImages[currentImage]);
//    			mImage2.setBackgroundResource(mImages[currentImage]);
    			BitmapDrawable mDrawable = (BitmapDrawable)mImage1.getDrawable();
    			
    			if(!mDrawable.getBitmap().isRecycled()) {
    				mDrawable.getBitmap().recycle();
    			}
    			mImage1.setImageBitmap(BitmapFactory.decodeResource(getResources(), mImages[currentImage]));
    			mImage2.setBackgroundResource(mImages[currentImage]);
    		}
    	});
    	
    	OnClickListener mAlphaListener = new OnClickListener() {
    		public void onClick(View v) {
    			if(v == mIncreaseButton) {
    				currentAlpha += 20;
    			} else if( v == mDecreaseButton) {
    				currentAlpha -= 20;
    			} else {}
    			
    			if(currentAlpha > 255) {
    				currentAlpha = 255;
    			} else if(currentAlpha < 0) {
    				currentAlpha = 0;
    			} else {}
    			
    			mImage1.setAlpha(currentAlpha);
    		}
    	};
    	
    	mIncreaseButton.setOnClickListener(mAlphaListener);
    	mDecreaseButton.setOnClickListener(mAlphaListener);
    	
    	mImage1.setOnTouchListener(new OnTouchListener() {
    		public boolean onTouch(View v, MotionEvent e) {
    			BitmapDrawable mDrawable = (BitmapDrawable)mImage1.getDrawable();
    			Bitmap mBitmap = (Bitmap)mDrawable.getBitmap();
    			
    			double mScale = mBitmap.getWidth() / 320;
    			int x = (int)(e.getX() * mScale);
    			int y = (int)(e.getY() * mScale);
    			
    			if((x + 120) > mBitmap.getWidth()) {
    				x = mBitmap.getWidth() - 120;
    			}
    			
    			if((y + 120) > mBitmap.getHeight()) {
    				y = mBitmap.getHeight() - 120;
    			}
    			
    			mImage2.setImageBitmap(Bitmap.createBitmap(mBitmap, x , y , 120, 120));
    			mImage2.setAlpha(currentAlpha);
    			
    			return false;
    		}
    	});
    }
}
