package org.crazyandroid.launcher;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class ActivityForResult extends Activity{
    Button bn;
    EditText city;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.buttonedittext);
        bn = (Button)findViewById(R.id.button);
        city =(EditText)findViewById(R.id.edittext);

        bn.setText(R.string.select_city);
        bn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityForResult.this, SelectCityActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0 && resultCode == 0) {
            Bundle data = intent.getExtras();
            String resultCity = data.getString("city");
            city.setText(resultCity);
        }
    }
}
