package org.crazyandroid.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    		final String[] mColors = {" red", " blue", " green"};
    		b.setMultiChoiceItems(mColors , checkStatus, new DialogInterface.OnMultiChoiceClickListener() {

				List<String> mList = new ArrayList<String>();
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					String result = "Color liked is : ";
					System.out.println(which + " is checked: " + isChecked);
					mText.setText(null);
					if(isChecked) {
						if(!mList.contains((Object)mColors[which])){
							System.out.println("mList add");
						    mList.add(mColors[which]);	
						}
					}
					if(!isChecked) {
						if(mList.contains((Object)mColors[which])){
							System.out.println("mList remove");
							mList.remove((Object)mColors[which]);
						}
					}
					System.out.println("mList Size : " + mList.size());
					String tmp = new String();
					for(int i = 0; i < mList.size(); i++) {
						if(!mList.get(i).toString().equals(null)) {
							tmp += mList.get(i).toString();
						}
					}
					
					result += tmp;
//					if(isChecked) {
//                        if(which == 0){
//                        	result += " red";
//                        }else if(which == 1){
//                        	result += " blue";
//                        }else if(which == 2){
//                        	result += " green";
//                        }else{}
//					}
					mText.setText(result);
				}
			});
    		
    		return b.create();
    	}
		return null;
    }
}
