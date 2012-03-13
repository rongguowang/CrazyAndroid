package org.crazyandroid.basic;


import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class ImageButtonActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.imagebutton);
    	
    	Button imageButton = (Button)findViewById(R.id.test);
    	imageButton.setOnClickListener(new OnClickListener () {
    		public void onClick(View v) {
    			System.out.println("image Button test pressed!");
    		}

    	});
    }
}
