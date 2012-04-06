package org.crazyandroid.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
public class CustomDialogActivity extends Activity {
	final int CUSTOM_DIALOG = 0x15;
	final String[] mNames = {"God", "Bug", "Human"};
	final int[] mImageIds = {R.drawable.p, R.drawable.z, R.drawable.t};
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);
    	final Button mOk = (Button)findViewById(R.id.ok_button);
    	mOk.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			showDialog(CUSTOM_DIALOG);
    		}
    	});
    }
    
    public Dialog onCreateDialog(int id, Bundle State) {
    	switch(id) {
    	case CUSTOM_DIALOG:
    		Builder b = new AlertDialog.Builder(CustomDialogActivity.this);
    		b.setIcon(R.drawable.icon);
    		b.setTitle("Custom Dialog");
    		List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
    		
    		for(int i = 0; i < mNames.length; i++){
    			Map<String, Object> mItem= new HashMap<String, Object>();
    			mItem.put("name", mNames[i]);
    			mItem.put("image", mImageIds[i]);
    			mList.add(mItem);
    		}
    		SimpleAdapter sa = new SimpleAdapter(this, mList, R.layout.row, new String[] {"name", "image"}, new int[] {R.id.name, R.id.header} );
    		b.setAdapter(sa, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					EditText mText = (EditText)findViewById(R.id.edittext1); 
					mText.setText(mNames[which]);
				}
			});
    		
    		return b.create();
    	}
    	return null;
    }
}
