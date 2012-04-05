package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
public class MultiChoiceDialogActivity extends Activity{
	final int MULTI_CHOICE = 0x14;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);
    	Button mButton = (Button)findViewById(R.id.ok_button);
    	mButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			showDialog(MULTI_CHOICE);
    		}
    	});
    }
    
    public Dialog onCreateDialog(int id, Bundle state) {
    	final EditText mText = (EditText)findViewById(R.id.edittext1);
    	switch(id) {
    	case MULTI_CHOICE:
    		Builder b = new AlertDialog.Builder(MultiChoiceDialogActivity.this);
    		b.setIcon(R.drawable.icon);
    		b.setTitle("multi choice dialog");
    		final boolean[] checkStatus = {false, false, false};
    		b.setMultiChoiceItems(new String[] {"red", "blue", "green"}, checkStatus, new DialogInterface.OnMultiChoiceClickListener() {
				String result = "Color liked is : ";
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					
					if(isChecked) {
                        if(which == 0){
                        	result += " red";
                        }else if(which == 1){
                        	result += " blue";
                        }else if(which == 2){
                        	result += " green";
                        }else{}
					}
					mText.setText(result);
				}
			});
    		
    		return b.create();
    	}
		return null;
    }
}
