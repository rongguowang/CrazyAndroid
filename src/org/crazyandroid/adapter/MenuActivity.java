package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
public class MenuActivity extends Activity {
	final int FONT_10 = 0x10;
	final int FONT_12 = 0x12;
	final int FONT_14 = 0x14;
	final int FONT_16 = 0x16;
	final int FONT_18 = 0x18;
	final int FONT_RED = 0x19;
	final int FONT_BLUE = 0x1A;
	final int FONT_GREEN = 0x1B;
	final int PLAIN_ITEM = 0x1C;
	EditText mText;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);
    	mText = (EditText)findViewById(R.id.edittext1);
    	mText.setText("Text Size");
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
    	SubMenu fontMenu = menu.addSubMenu("Font Size");
    	fontMenu.setIcon(R.drawable.font);
    	fontMenu.setHeaderIcon(R.drawable.font);
    	fontMenu.setHeaderTitle("Please choose the font Size");
    	fontMenu.add(0, FONT_10, 0, "font 10");
    	fontMenu.add(0, FONT_12, 0, "font 12");
    	fontMenu.add(0, FONT_14, 0, "font 14");
    	fontMenu.add(0, FONT_16, 0, "font 16");
    	fontMenu.add(0, FONT_18, 0, "font 18");
    	
    	menu.add(0, PLAIN_ITEM, 0, "Plain menu");
    	
    	SubMenu colorMenu = menu.addSubMenu("Font Color");
    	colorMenu.add(0, FONT_RED, 0, "Red");
    	colorMenu.add(0, FONT_BLUE, 0, "Blue");
    	colorMenu.add(0, FONT_GREEN, 0, "Green");
    	
    	return super.onCreateOptionsMenu(menu);
    }
    
    public boolean onOptionsItemSelected(MenuItem mi) {
    	switch(mi.getItemId()) {
    	case FONT_10:
    		mText.setTextSize(10 *2);
    		break;
    	case FONT_12:
    		mText.setTextSize(12 * 2);
    		break;
    	case FONT_14:
    		mText.setTextSize(14 * 2);
    		break;
    	case FONT_16:
    		mText.setTextSize(16 * 2);
    		break;
    	case FONT_18:
    	    mText.setTextSize(18 * 2);
    	    break;
    	case FONT_RED:
    		mText.setTextColor(R.color.red);
    		break;
    	case FONT_BLUE:
    		mText.setTextColor(R.color.blue);
    		break;
    	case FONT_GREEN:
    		mText.setTextColor(R.color.green);
    		break;
    	case PLAIN_ITEM:
    		Toast t = Toast.makeText(MenuActivity.this, "the plain item have been clicked", Toast.LENGTH_LONG);
    		t.show();
    		break;
    	default:
    		break;
    	}
    	return true;
    }
}
