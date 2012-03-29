package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListAdapterActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.listlayout);
    	
    	final ListView mList = (ListView)findViewById(R.id.list1);
    	
    	String[] arr = {"monkey sun", "pig zhu", "bull niu"};
    	
    	ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
    	
    	mList.setAdapter(arrayAdapter);
    }
}
