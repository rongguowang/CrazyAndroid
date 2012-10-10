package org.crazyandroid.launcher;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.content.Intent;
public class LauncherListActivity extends LauncherActivity {
	String[] names = {"Property Activity",
			"StarCraft Activity",
            "ActivityForResult",
            "ComponentStartActivity"};
	Class<?>[] clazzs = {PreferencesActivity.class,
			ExpandableActivity.class,
            ActivityForResult.class,
            ComponentStartActivity.class};
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,names);
    	setListAdapter(adapter);
    }
    
    public Intent intentForPosition(int position) {
        return new Intent(LauncherListActivity.this, clazzs[position]);    	
    }
}
