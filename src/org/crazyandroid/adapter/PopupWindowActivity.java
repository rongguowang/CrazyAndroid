package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
public class PopupWindowActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);
    	View root = this.getLayoutInflater().inflate(R.layout.popup, null);
    	final PopupWindow popup = new PopupWindow(root, 600, 480);
    	Button mOk = (Button)findViewById(R.id.ok_button);
    	mOk.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			popup.showAtLocation(findViewById(R.id.ok_button), Gravity.CENTER, 20, 20);
    		}
    	});
    	root.findViewById(R.id.close).setOnClickListener(
    		new View.OnClickListener() {

				public void onClick(View v) {
					popup.dismiss();
				}
			}
    	); 
    }
}
