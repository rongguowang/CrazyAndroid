package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;

public class ListDialogActivity extends Activity{
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);
    	
    	final EditText mView = (EditText)findViewById(R.id.edittext1);
    	final Button mButton = (Button)findViewById(R.id.ok_button);
    	final Builder mDialog = new AlertDialog.Builder(ListDialogActivity.this);
    	
    	mButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			mDialog.setIcon(R.drawable.icon);
    			mDialog.setTitle("Simple Dialog");
    			mDialog.setItems(new String[]{"red", "blue", "green"}, new DialogInterface.OnClickListener() {
    				public void onClick(DialogInterface dialog, int which) {
    					switch(which) {
    					case 0:
    						mView.setText("red");
    						break;
    					case 1:
    						mView.setText("blue");
    						break;
    					case 2:
    						mView.setText("green");
    						break;
    					default:
    						break;
    					}
    				}
    			});
    			mDialog.create().show();
    		}
    	});
    }
}
