package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ImageSwitcher;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import android.view.View;
import android.view.animation.AnimationUtils;
public class GalleryActivity extends Activity {
	int[] mImageIds = {R.drawable.baiyang, R.drawable.chunv, R.drawable.jinniu, R.drawable.juxie, R.drawable.mojie, R.drawable.sheshou,
			R.drawable.shizi, R.drawable.shuangyu, R.drawable.shuangzi, R.drawable.shuiping, R.drawable.tiancheng, R.drawable.tianxie};
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.gallerylayout);
    	final ImageSwitcher switcher = (ImageSwitcher)findViewById(R.id.switcher);
    	final Gallery gallery = (Gallery)findViewById(R.id.gallery);
    	
    	switcher.setFactory(new ViewFactory() {
    		public View makeView() {
    			ImageView imageView = new ImageView(GalleryActivity.this);
    			imageView.setBackgroundColor(0xff0000);
    			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    			imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    			return imageView;
    		}
    	});
    	
    	switcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
    	switcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
    	
    	BaseAdapter ba = new BaseAdapter() {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mImageIds.length;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				ImageView imageView = new ImageView(GalleryActivity.this);
				imageView.setImageResource(mImageIds[position % mImageIds.length]);
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new Gallery.LayoutParams(75, 100));
//				TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
//				imageView.setBackgroundResource(typedArray.getResourceId(R.styleable.Gallery_android_galleryItemBackground, 0));
				return imageView;
			}};
			
			gallery.setAdapter(ba);
			gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					switcher.setBackgroundResource(mImageIds[position % mImageIds.length]);
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {}
			});
    }
}
