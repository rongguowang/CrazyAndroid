package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
public class SingleChoiceDialogActivity extends Activity {
	final int SINGLE_DIALOG = 0x13;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);

    	final Button mButton = (Button)findViewById(R.id.ok_button);
    	mButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			showDialog(SINGLE_DIALOG);
    		}
    	});

    }
	
	public Dialog onCreateDialog(int id, Bundle state) {
    	final EditText mText = (EditText)findViewById(R.id.edittext1);
		switch(id) {
		case SINGLE_DIALOG:
			Builder b = new AlertDialog.Builder(SingleChoiceDialogActivity.this);
		    b.setIcon(R.drawable.icon);
		    b.setTitle("Single Choice Dialog");
		    b.setSingleChoiceItems(new String[] {"red", "blue", "green"}, 1, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					switch(which) {
					case 0:
						mText.setText("red");
						break;
					case 1:
						mText.setText("blue");
						break;
					case 2:
						mText.setText("green");
						break;
				    default:
				    	break;
					}
				}
			});
		    
		    b.setPositiveButton("OK", null);
		    
		    return b.create();
		}
		return null;
	}
}
