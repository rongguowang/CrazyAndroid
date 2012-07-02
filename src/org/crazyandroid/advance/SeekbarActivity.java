package org.crazyandroid.advance;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
public class SeekbarActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	setContentView(R.layout.seekbarlayout);
    	
    	
    	final ImageView mImage = (ImageView)findViewById(R.id.image1);
    	final SeekBar mSeekBar = (SeekBar)findViewById(R.id.seekbar1);
    	final RatingBar mRatingbar = (RatingBar)findViewById(R.id.ratingbar1);
    	
    	mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener () {
    		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    		    mImage.setAlpha(progress);	
    		}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
    	});
    	
    	mRatingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
    		public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
    			mImage.setAlpha((int)(rating * 255 / 5));
    		}

    	});
    }
}
