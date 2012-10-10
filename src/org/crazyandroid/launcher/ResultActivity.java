package org.crazyandroid.launcher;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.ComponentName;

public class ResultActivity extends Activity{
    private TextView textview = null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview);
        textview = (TextView)findViewById(R.id.textview1);
        ComponentName component = getIntent().getComponent();
        StringBuffer sb = new StringBuffer();
        sb.append(component.getPackageName());
        sb.append("\n");
        sb.append(component.getClassName());
        textview.setText(sb);
    }
}
