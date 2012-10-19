package org.crazyandroid.launcher;

import org.crazyandroid.sample.R;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.ComponentName;
import android.content.Intent;

public class ComponentStartActivity extends Activity {
    private Button button = null;
    private Button button2 = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);

        button = (Button)findViewById(R.id.button1);
        button.setText("startActivity");
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ComponentName component = new ComponentName(ComponentStartActivity.this, ResultActivity.class);
                Intent intent = new Intent();
                intent.setComponent(component);
                startActivity(intent);
            }
        });

        button2 = (Button)findViewById(R.id.button2);
        button2.setText("ActionStartActivity");
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("helloworld");
                intent.addCategory("helloworld");
                startActivity(intent);
            }
        });
    }
}
