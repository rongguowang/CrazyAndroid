package org.crazyandroid.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.view.View;

public class MaxViewActivity extends Activity{
	int[] images = new int[]{
			R.drawable.colourfulimage,
			R.drawable.webpage,
			R.drawable.girl};
	int currentImg = 0;
	
    public void onCreate(Bundle savedInstanceState){
    	super.onCreate(savedInstanceState);

    	setContentView(R.layout.genericlinear);
    	LinearLayout layout = (LinearLayout)findViewById(R.id.generic_linear);
    	
    	final ImageView image = new ImageView(this);
    	
    	layout.addView(image);
    	
    	image.setImageResource(images[currentImg]);
    	
    	image.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			System.out.println("currentImg = " + currentImg);
    			if(currentImg >= 2) {
    				currentImg = -1;
    			}
    			image.setImageResource(images[++currentImg]);
    		}
    	});
    }
}
