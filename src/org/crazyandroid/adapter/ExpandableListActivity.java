package org.crazyandroid.adapter;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.LinearLayout;
public class ExpandableListActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.expandablelayout);
    	
    	ExpandableListAdapter mAdapter = new BaseExpandableListAdapter() {
    		int[] logos = {R.drawable.p, R.drawable.z, R.drawable.t};
    		private String[] armTypes = {"shenzu", "chongzu", "renzu"};
    	    private String[][] arms = {{"kuangzhanshi", "longqishi", "heianshengtang", "dianbing"},
    	    		{"xiaogou", "cishe", "feilong", "zibaofeiji"},
    	    		{"jiqiangbing", "hushimeizi", "youling"}};
    	    public Object getChild(int groupPosition, int childPosition) {
    	    	return arms[groupPosition][childPosition];
    	    }
    	    public long getChildId(int groupPosition, int childPosition) {
    	    	return childPosition;
    	    }
    	    public int getChildrenCount(int groupPosition) {
    	    	return arms[groupPosition].length;
    	    }
    	    private TextView getTextView() {
    	    	AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
    	    	
    	    	TextView textView = new TextView(ExpandableListActivity.this);
    	    	textView.setLayoutParams(lp);
    	    	textView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.LEFT);
    	    	textView.setPadding(36, 0, 0, 0);
    	    	textView.setTextSize(20);
    	    	
    	    	return textView;
    	    }
    	    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
    	    	TextView textView = getTextView();
    	    	textView.setText(getChild(groupPosition, childPosition).toString());
    	    	return textView;
    	    }
    	    
    	    public Object getGroup(int groupPosition) {
    	    	return armTypes[groupPosition];
    	    }
    	    public int getGroupCount() {
    	    	return armTypes.length;
    	    }
    	    public long getGroupId(int groupPosition) {
    	    	return groupPosition;
    	    }
    	    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
    	    	LinearLayout ll = new LinearLayout(ExpandableListActivity.this);
    	    	ll.setOrientation(0);
    	    	ImageView logo = new ImageView(ExpandableListActivity.this);
    	    	logo.setImageResource(logos[groupPosition]);
    	    	ll.addView(logo);
    	    	TextView textview = getTextView();
    	    	textview.setText(getGroup(groupPosition).toString());
    	    	ll.addView(textview);
    	    	return ll;
    	    }
    	    public boolean isChildSelectable(int groupPosition, int childPosition) {
    	    	return true;
    	    }
    	    public boolean hasStableIds() {
    	    	return true;
    	    }
    	};
    	
	    ExpandableListView expandableListView = (ExpandableListView)findViewById(R.id.listview1);
	    expandableListView.setAdapter(mAdapter);
    }
}
