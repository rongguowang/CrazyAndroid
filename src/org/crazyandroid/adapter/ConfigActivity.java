package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
public class ConfigActivity extends Activity{
	EditText ori = null;
	EditText navigation = null;
	EditText touch = null;
	EditText mnc = null;
	Button ok = null;
	Button change = null;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.configlayout);
    	
    	ori = (EditText)findViewById(R.id.ori);
    	navigation = (EditText)findViewById(R.id.navigation);
    	touch = (EditText)findViewById(R.id.touch);
    	mnc = (EditText)findViewById(R.id.mnc);
    	
    	ok = (Button)findViewById(R.id.ok);
    	ok.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Configuration cfg = getResources().getConfiguration();
    			String screen = (cfg.orientation == Configuration.ORIENTATION_LANDSCAPE)?"landscape":"vertical";
    			String mncCode = cfg.mnc + "";
    			String naviName = ((cfg.orientation == Configuration.NAVIGATION_NONAV)?"no control":((cfg.orientation == Configuration.NAVIGATION_WHEEL)?"navigation wheel":(cfg.orientation == Configuration.NAVIGATION_DPAD)?"dpad control":"track ball control"));
    			navigation.setText(naviName);
    			String touchName = (cfg.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH)?"no touch screen":((cfg.touchscreen == Configuration.TOUCHSCREEN_STYLUS)?"stylus touch":"finger touch");
    			ori.setText(screen);
    			mnc.setText(mncCode);
    			touch.setText(touchName);
    		}
    	});
    	
    	change = (Button)findViewById(R.id.change);
    	change.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Configuration cfg = getResources().getConfiguration();
    			if (cfg.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    				ConfigActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    			}
    			
    			if (cfg.orientation == Configuration.ORIENTATION_PORTRAIT) {
    				ConfigActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    			}
    		}
    	});
    }
    
	public void onConfigurationChanged(Configuration config) {
		super.onConfigurationChanged(config);
		
		String screen = config.orientation == Configuration.ORIENTATION_LANDSCAPE ? "landscape" : "vertical";
		Toast.makeText(this, "orientation changed to: " + screen, Toast.LENGTH_LONG).show();
	}
}
