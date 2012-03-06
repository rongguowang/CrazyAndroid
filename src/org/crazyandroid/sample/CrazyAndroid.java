package org.crazyandroid.sample;

import android.app.Activity;
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
	}
}
