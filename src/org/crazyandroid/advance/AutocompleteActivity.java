package org.crazyandroid.advance;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;

public class AutocompleteActivity extends Activity {
	String[] mBooks = new String [] {
		"crazy android",
		"crazy Java",
		"crazy J2EE",
		"crazy JSP",
		"crazy XML"
	};
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.autocompletelayout);
    	
    	ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, mBooks);
    	
    	AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.autocomplete);
    	actv.setAdapter(aa);
    }
}
