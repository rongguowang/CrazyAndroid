package org.crazyandroid.launcher;

import org.crazyandroid.sample.R;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.AbsListView.LayoutParams;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SelectCityActivity extends ExpandableListActivity{
    private String[] provinces = new String[]{"China", "Japan", "USA"};
    private String[][] cities = new String[][]
            {
            {"BeiJing", "ShangHai", "ChengDu"},
            {"Tokyo", "Ido"},
            {"DC", "SanFransisco", "Canifonia"},
            };
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            public Object getChild(int groupPosition, int ChildPosition) {
                return cities[groupPosition][ChildPosition];
            }
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }
            private TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
                TextView textview = new TextView(SelectCityActivity.this);
                textview.setLayoutParams(lp);
                textview.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textview.setPadding(36, 0, 0, 0);
                textview.setTextSize(20);
                return textview;
            }
            @Override
            public View getChildView(int groupPosition, int childPosition,
                    boolean isLastChild, View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                TextView textview = getTextView();
                textview.setText(getChild(groupPosition, childPosition).toString());
                return textview;
            }
            @Override
            public int getChildrenCount(int groupPosition) {
                // TODO Auto-generated method stub
                return cities[groupPosition].length;
            }
            @Override
            public Object getGroup(int groupPosition) {
                // TODO Auto-generated method stub
                return provinces[groupPosition];
            }
            @Override
            public int getGroupCount() {
                // TODO Auto-generated method stub
                return provinces.length;
            }
            @Override
            public long getGroupId(int groupPosition) {
                // TODO Auto-generated method stub
                return groupPosition;
            }
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded,
                    View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                LinearLayout ll = new LinearLayout(SelectCityActivity.this);
                ll.setOrientation(0);
                ImageView logo = new ImageView(SelectCityActivity.this);
                ll.addView(logo);
                TextView textview = getTextView();
                textview.setText(getGroup(groupPosition).toString());
                ll.addView(textview);
                return ll;
            }
            @Override
            public boolean hasStableIds() {
                return true;
            }
            @Override
            public boolean isChildSelectable(int groupPosition,
                    int childPosition) {
                return true;
            }
        };

        setListAdapter(adapter);

        getExpandableListView().setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
                Intent intent = getIntent();
                Bundle data = new Bundle();
                data.putString("city", cities[groupPosition][childPosition]);
                intent.putExtras(data);
                SelectCityActivity.this.setResult(0, intent);
                SelectCityActivity.this.finish();
                return false;
            }});
    }
}
