package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Button;

public class CheckableMenuActivity extends Activity{
	final int MALE = 0x0111;
	final int FEMALE = 0x0112;
	final int RED = 0x1113;
	final int BLUE = 0x1114;
	final int GREEN = 0x1115;
	MenuItem[] items = new MenuItem[3];
	String[] mColourNames = new String[]{"red", "blue", "green"};
	private EditText edit;
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.dialoglayout);
    	edit = (EditText)findViewById(R.id.edittext1);
    	edit.setText("text size");
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
    	SubMenu genderMenu = menu.addSubMenu("your gender");
    	genderMenu.setIcon(R.drawable.gender);
    	genderMenu.setHeaderIcon(R.drawable.gender);
    	genderMenu.setHeaderTitle("choose your gender");
    	genderMenu.add(0, MALE, 0, "male");
    	genderMenu.add(0, FEMALE, 0, "female");
    	genderMenu.setGroupCheckable(0, true, true);
    	
    	SubMenu colourMenu = menu.addSubMenu("your liked Colour");
    	colourMenu.setIcon(R.drawable.colour);
    	colourMenu.setHeaderIcon(R.drawable.colour);
    	colourMenu.setHeaderTitle("choose the colour you liked");
    	items[0] = colourMenu.add(0, RED, 0, mColourNames[0]);
    	items[1] = colourMenu.add(0, BLUE, 0, mColourNames[1]);
    	items[2] = colourMenu.add(0, GREEN, 0, mColourNames[2]);
    	items[2].setAlphabeticShortcut('u');
    	
    	return super.onCreateOptionsMenu(menu);
    }
    
    public boolean onOptionsItemSelected(MenuItem mi) {
    	switch(mi.getItemId()) {
    	case MALE:
    		edit.setText("your gender is: male");
    		mi.setCheckable(true);
    		break;
    	case FEMALE:
    		edit.setText("your gender is: female");
    		mi.setCheckable(true);
    		break;
    	case RED:
    		if(mi.isChecked()) {
    			mi.setChecked(false);
    		} else {
    			mi.setChecked(true);
    		}
    		showColour();
    		break;
    	case BLUE:
    		if(mi.isChecked()) {
    			mi.setChecked(false);
    		} else {
    			mi.setChecked(true);
    		}
    		showColour();
    		break;
    	case GREEN:
    		if(mi.isChecked()) {
    			mi.setChecked(false);
    		} else {
    			mi.setChecked(true);
    		}
    		showColour();
    		break;
    	default:
    		break;
    	}
    	return true;
    }
    
    private void showColour() {
    	String result = "the colour you liked is: ";
    	
    	for(int i = 0; i < items.length; i++) {
    		if(items[i].isChecked()) {
    			result += mColourNames[i] + ".";
    		}
    	}
    	
    	edit.setText(result);
    }
}
