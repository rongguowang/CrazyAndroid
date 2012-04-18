package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
public class ContextMenuActivity extends Activity{
	final int MENU1 = 0x111;
	final int MENU2 = 0x112;
	final int MENU3 = 0x113;
	private TextView tt;
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);
    	tt = (TextView)findViewById(R.id.textview1);
    	registerForContextMenu(tt);
    }
    
    public void onCreateContextMenu(ContextMenu menu, View source, ContextMenu.ContextMenuInfo menuInfo) {
    	menu.add(0, MENU1, 0, "red");
    	menu.add(0, MENU2, 0, "blue");
    	menu.add(0, MENU3, 0, "green");
    	menu.setGroupCheckable(0, true, true);
    	menu.setHeaderIcon(R.drawable.tools);
    	menu.setHeaderTitle("please choose one colour");
    }
    
    public boolean onContextItemSelected(MenuItem mi) {
    	switch(mi.getItemId()) {
    	case MENU1:
    		mi.setChecked(true);
    		tt.setBackgroundColor(R.color.red);
    		tt.setText("red");
    		break;
    	case MENU2:
    		mi.setChecked(true);
    		tt.setBackgroundColor(R.color.blue);
    		tt.setText("blue");
    		break;
    	case MENU3:
    		mi.setChecked(true);
    		tt.setBackgroundColor(R.color.green);
    		tt.setText("green");
    		break;
    	default:
    		break;
    	}
    	return true;
    }
}
