package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.View;

public class AdapterActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.adapterlayout);
    	
    	Button mListButton = (Button)findViewById(R.id.listadapter_button);
    	mListButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, ListAdapterActivity.class);
    			startActivity(intent);
    		}
    	});
    }
}
