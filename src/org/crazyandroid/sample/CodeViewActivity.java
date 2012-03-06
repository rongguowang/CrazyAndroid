package org.crazyandroid.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;

public class CodeViewActivity extends Activity{

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		LinearLayout layout = new LinearLayout(this);
		super.setContentView(layout);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		final TextView show = new TextView(this);
		
		Button bn = new Button(this);
		bn.setText(R.string.code_view_button_text);
		bn.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		
		layout.addView(show);
		layout.addView(bn);
		
		bn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				show.setText("Hello Android, " + new java.util.Date());
			}
		});
	}
}
