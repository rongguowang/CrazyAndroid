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
    	Button mCustomDialog = (Button)findViewById(R.id.customdialog_button);
    	mCustomDialog.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, CustomDialogActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mLogin = (Button)findViewById(R.id.logindialog_button);
    	mLogin.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, LoginDialogActivity.class);
    			startActivity(intent);
    		}
    	});

    	Button mPopUp = (Button)findViewById(R.id.popupwindow_button);
    	mPopUp.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, PopupWindowActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mDateDialog = (Button)findViewById(R.id.datedialog_button);
    	mDateDialog.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, DateDialogActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mProgressDialog = (Button)findViewById(R.id.progressdialog_button);
    	mProgressDialog.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, ProgressDialogActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mToast = (Button)findViewById(R.id.toast_button);
    	mToast.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, ToastActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mNotification = (Button)findViewById(R.id.notification_button);
    	mNotification.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, NotificationActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mMenu = (Button)findViewById(R.id.menu_button);
    	mMenu.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, MenuActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mCheckableMenu = (Button)findViewById(R.id.checkablemenu_button);
    	mCheckableMenu.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, CheckableMenuActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mContextMenu = (Button)findViewById(R.id.contextmenu_button);
    	mContextMenu.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, ContextMenuActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mPlane = (Button)findViewById(R.id.plane_button);
    	mPlane.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, PlaneActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	Button mClickableButton = (Button)findViewById(R.id.clickable_button);
    	mClickableButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(AdapterActivity.this, ClickableButtonActivity.class);
    			startActivity(intent);
    		}
    	});
    }
}
