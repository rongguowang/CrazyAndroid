package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
public class DialogActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);
    	final EditText mText= (EditText)findViewById(R.id.edittext1);
    	final Button mButton = (Button)findViewById(R.id.ok_button);
    	final Builder mBuilder = new AlertDialog.Builder(DialogActivity.this);
    	mButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			mBuilder.setIcon(R.drawable.icon);
    			mBuilder.setTitle("own dialog");
    			mBuilder.setMessage("simple dialog");
    			mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    				public void onClick(DialogInterface dialog, int which) {
    					mText.setText("OK is pressed");
    				}
    			});
    			mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    				public void onClick(DialogInterface dilaog, int which) {
    				    mText.setText("Cancel is pressed.");	
    				}
    			});
    			mBuilder.create().show();
    		}
    	});
    }
}
