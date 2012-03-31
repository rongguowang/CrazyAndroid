package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.ImageView;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.Object;
public class GridActivity extends Activity {
	int[] mImageIds = {R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7, R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10,
			R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16};
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.gridlayout);
    	
    	List<Map<String, Object>> mListItems = new ArrayList<Map<String, Object>>();
    	for(int i = 0; i < mImageIds.length; i++) {
    		Map<String, Object> listItem = new HashMap<String, Object>();
    		listItem.put("image", mImageIds[i]);
    		mListItems.add(listItem);
    	}
    	
    	final ImageSwitcher switcher = (ImageSwitcher)findViewById(R.id.switcher); 
    	switcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
    	switcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
    	switcher.setFactory(new ViewFactory() {
    		public View makeView() {
    			ImageView mImage = new ImageView(GridActivity.this);
    			mImage.setBackgroundColor(0xff0000);
    			mImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
    			mImage.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    			return mImage;
    		}
    	});
    	
    	SimpleAdapter simpleAdapter = new SimpleAdapter(this, mListItems, R.layout.cell, new String[]{"image"}, new int[]{R.id.image1});
    	
    	GridView grid = (GridView)findViewById(R.id.grid);
    	grid.setAdapter(simpleAdapter);
    	grid.setOnItemSelectedListener(new OnItemSelectedListener() {
    		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    			switcher.setImageResource(mImageIds[position % mImageIds.length]);
    		}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
    	});
    	
    	grid.setOnItemClickListener(new OnItemClickListener() {
    		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    			switcher.setImageResource(mImageIds[position % mImageIds.length]);
    		}
    	});
    }
}
