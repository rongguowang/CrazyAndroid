package org.crazyandroid.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CrazyAndroid extends Activity{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		Button bn = (Button)findViewById(R.id.ok);
		
		bn.setOnClickListener(new OnClickListener() {
			public void onClick(View v){
				final TextView show = (TextView)findViewById(R.id.show);
				show.setText("Hello Android~" + new java.util.Date());
			}
		});
		
		Button mCodeView = (Button) findViewById(R.id.codeview);
		mCodeView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(CrazyAndroid.this, CodeViewActivity.class);
				startActivity(intent);
			}
		});
		
		Button mMaxView = (Button)findViewById(R.id.maxview);
		mMaxView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(CrazyAndroid.this, MaxViewActivity.class);
				startActivity(intent);
			}
		});
		
		Button mCustomView = (Button)findViewById(R.id.customview);
		mCustomView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(CrazyAndroid.this, CustomViewActivity.class);
				startActivity(intent);
			}
		});
	}
}
