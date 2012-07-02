package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.app.Dialog;
import android.content.DialogInterface;

public class LoginDialogActivity extends Activity {
	final int LOGIN_DIALOG = 0x16;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);
    	
    	Button mOk = (Button)findViewById(R.id.ok_button);
    	mOk.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			showDialog(LOGIN_DIALOG);
    		}
    	});
    }
    
    public Dialog onCreateDialog(int id, Bundle state) {
    	final EditText mView = (EditText)findViewById(R.id.edittext1);
    	switch(id) {
    	case LOGIN_DIALOG:
    		Builder mLogin = new AlertDialog.Builder(LoginDialogActivity.this);
    		mLogin.setIcon(R.drawable.icon);
    		mLogin.setTitle("Login Dialog");
    		TableLayout mTable = (TableLayout)getLayoutInflater().inflate(R.layout.loginlayout, null);
    		mLogin.setView(mTable);
    		mLogin.setPositiveButton("log in", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					mView.setText("log in");
				}
			});
    		mLogin.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					mView.setText("cancel");
				}
			});
    		return mLogin.create();
    	}
    	return null;
    }
}
