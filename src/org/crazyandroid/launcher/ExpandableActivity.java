package org.crazyandroid.launcher;

import org.crazyandroid.sample.R;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
public class ExpandableActivity extends ExpandableListActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
			int[] logos = new int[] {
					R.drawable.p,
					R.drawable.z,
					R.drawable.t,
			};
			private String[] armTypes  = new String[] {
					"shenzu",
					"chongzu",
					"renzu",
			};
			private String[][]  arms = new String[][] {
					{"kuangzhanshi","longqishi","heianshengtang","dianbing",},
					{"xiaogou", "cishe", "feilong", "zibaofeiji",},
					{"jiqiangbing", "hushiMM", "youling",},
			};
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				return arms[groupPosition][childPosition];
			}
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				return childPosition;
			}
			private TextView getTextView() {
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
				TextView textView = new TextView(ExpandableActivity.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
				textView.setPadding(36, 0, 0, 0);
				textView.setTextSize(20);
				
				return textView;
			}
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition, childPosition).toString());
				return textView;
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return arms[groupPosition].length;
			}
			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return armTypes[groupPosition];
			}
			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return armTypes.length;
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
				
				LinearLayout ll = new LinearLayout(ExpandableActivity.this);
				ll.setOrientation(0);
				ImageView logo = new ImageView(ExpandableActivity.this);
				logo.setImageResource(logos[groupPosition]);
				ll.addView(logo);
				TextView textView = getTextView();
				textView.setText(getGroup(groupPosition).toString());
				ll.addView(textView);
				
				return ll;
			}
			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return true;
			}
			@Override
			public boolean isChildSelectable(int groupPosition,
					int childPosition) {
				// TODO Auto-generated method stub
				return true;
			}
		};
		
		setListAdapter(adapter);
	}
}
