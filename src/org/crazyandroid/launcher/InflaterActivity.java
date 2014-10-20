package org.crazyandroid.launcher;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class InflaterActivity extends Activity{
    private RelativeLayout layout = null;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.empty_relative_layout);

        layout = (RelativeLayout)this.findViewById(R.id.empty_relative);
        LayoutInflater inflater = LayoutInflater.from(this);
//        View cell = (View)inflater.inflate(R.layout.cell2, layout, false);
//        cell.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//        LayoutParams params= new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        layout.addView(cell, params);
        
        ViewStub cell = (ViewStub)this.findViewById(R.id.view_stub);
        cell.setVisibility(View.VISIBLE);
    }

}
