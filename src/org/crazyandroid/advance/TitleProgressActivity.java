package org.crazyandroid.advance;
import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;

public class TitleProgressActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_PROGRESS);
    	requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    	setContentView(R.layout.progresslayout2);
    	
    	final Button mButton1 = (Button)findViewById(R.id.progress2_button1);
    	final Button mButton2 = (Button)findViewById(R.id.progress2_button2);
    	mButton1.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			setProgressBarIndeterminateVisibility(true);
    			setProgressBarVisibility(true);
    			setProgress(4500);
    		}
    	});
    	
    	mButton2.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			setProgressBarIndeterminateVisibility(false);
    			setProgressBarVisibility(false);
    		}
    	});
    }
}
