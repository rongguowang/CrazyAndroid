package org.crazyandroid.adapter;

import java.util.Calendar;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.view.View.OnClickListener;
public class DateDialogActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.datedialoglayout);
    	
    	final Button mDateBn = (Button)findViewById(R.id.datebn);
    	final Button mTimeBn = (Button)findViewById(R.id.timebn);
    	
    	mDateBn.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Calendar c = Calendar.getInstance();
    			new DatePickerDialog(DateDialogActivity.this, new DatePickerDialog.OnDateSetListener() {
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						EditText show = (EditText)findViewById(R.id.edittext2);
						show.setText("year: " + year + " month: " + (monthOfYear + 1) + " day :" + (dayOfMonth));
					}
				}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    		}
    	});
    	
    	mTimeBn.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Calendar c = Calendar.getInstance();
    			new TimePickerDialog(DateDialogActivity.this,new TimePickerDialog.OnTimeSetListener() {
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						EditText show = (EditText)findViewById(R.id.edittext2);
						show.setText("hour of day : "  + hourOfDay + " minute : " + minute);
					}
				}, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true).show();
    		}
    	});
    }
}
