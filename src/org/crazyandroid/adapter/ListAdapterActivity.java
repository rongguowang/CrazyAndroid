package org.crazyandroid.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListAdapterActivity extends Activity{
	String[] mNames = {"tiger", "nongyu", "qingzhao", "libai"};
	int[] mIds = {R.drawable.tiger, R.drawable.nongyu, R.drawable.qingzhao, R.drawable.libai};
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.listlayout);
    	
    	final ListView mList = (ListView)findViewById(R.id.list1);
    	
    	String[] arr = {"monkey sun", "pig zhu", "bull niu"};
    	
//    	ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
    	
//    	ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arr);
    	
//    	ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arr);
    	
    	List<Map<String, Object>> mListItems = new ArrayList<Map<String, Object>>();
    	
    	for(int i = 0; i < mNames.length; i++) {
    		Map<String, Object> mItem = new HashMap<String, Object>();
    		mItem.put("header", mIds[i]);
    		mItem.put("personName", mNames[i]);
    		mListItems.add(mItem);
    	}
    	
    	SimpleAdapter simpleAdapter = new SimpleAdapter(this, mListItems, R.layout.listlayout,
    			new String[]{"personName", "header"}, new int[]{R.id.name, R.id.header});
    	mList.setAdapter(simpleAdapter);
    }
}
