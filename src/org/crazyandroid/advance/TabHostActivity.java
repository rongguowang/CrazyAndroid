package org.crazyandroid.advance;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class TabHostActivity extends TabActivity {
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	TabHost mTab = getTabHost();
    	
    	LayoutInflater.from(this).inflate(R.layout.tablayout, mTab.getTabContentView(), true);
    	
    	mTab.addTab(mTab.newTabSpec("tab1").setIndicator("incoming call").setContent(R.id.linear1));
    	
    	mTab.addTab(mTab.newTabSpec("tab2").setIndicator("out call", this.getResources().getDrawable(R.drawable.icon)).setContent(R.id.linear2));
    	
    	mTab.addTab(mTab.newTabSpec("tab3").setIndicator("no answer call").setContent(R.id.linear3));
    }
}
