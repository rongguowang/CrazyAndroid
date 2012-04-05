package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.View;

public class AdapterActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.adapterlayout);
    	
    	Button mListButton = (Button)findViewById(R.id.listadapter_button);
    	mListButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, ListAdapterActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mExpandable = (Button)findViewById(R.id.expandablelist_button);
    	mExpandable.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, ExpandableListActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mGrid =(Button)findViewById(R.id.grid_button);
    	mGrid.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, GridActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mGallery = (Button)findViewById(R.id.gallery_button);
    	mGallery.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, GalleryActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mDialog = (Button)findViewById(R.id.dialog_button1);
    	mDialog.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, DialogActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mListDialog = (Button)findViewById(R.id.listdialog_button);
    	mListDialog.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, ListDialogActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mSingleChoiceDialog = (Button)findViewById(R.id.singledialog_button);
    	mSingleChoiceDialog.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, SingleChoiceDialogActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mMultiDialog = (Button)findViewById(R.id.multidialog_button);
    	mMultiDialog.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, MultiChoiceDialogActivity.class);
    			startActivity(intent);
    		}
    	});
    }
}
