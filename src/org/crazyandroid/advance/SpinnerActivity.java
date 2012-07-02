package org.crazyandroid.advance;

import org.crazyandroid.sample.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ImageView;

public class SpinnerActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.spinnerlayout1);
    	
    	final Spinner mSpinner1 = (Spinner)findViewById(R.id.spinner1);
    	
    	BaseAdapter ba = new BaseAdapter(){

			public int getCount() {
				// TODO Auto-generated method stub
				return 10;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView mText = new TextView(SpinnerActivity.this);
				mText.setText(position + "");
				mText.setTextSize(20);
				mText.setTextColor(R.color.red);
				return mText;
			}};
			
			mSpinner1.setAdapter(ba);
			
			final Spinner mSpinner2 = (Spinner)findViewById(R.id.spinner2);
			
			BaseAdapter ba2 = new BaseAdapter() {
				public int getCount() {
					return 10;
				}
				public Object getItem(int position) {
					return null;
				}
				public long getItemId(int position) {
					return 0;
				}
				public View getView(int position, View convertView, ViewGroup parent) {
					LinearLayout line = new LinearLayout(SpinnerActivity.this);
					line.setOrientation(0);
					ImageView image = new ImageView(SpinnerActivity.this);
					image.setImageResource(R.drawable.icon);
					TextView text = new TextView(SpinnerActivity.this);
					text.setText(position + "");
					text.setTextSize(20);
					text.setTextColor(R.color.red);
					line.addView(text);
					line.addView(image);
					
					
					return line;
				}
			};
			
			mSpinner2.setAdapter(ba2);
    }
}
