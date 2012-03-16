package org.crazyandroid.advance;

import java.util.Calendar;

import org.crazyandroid.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.EditText;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker.OnTimeChangedListener;

public class TimeDateActivity extends Activity{
	private int mYear = 0;
	private int mMonth = 0;
	private int mDay = 0;
	private int mHour = 0;
	private int mMinute = 0;
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.timedatelayout);
    	
    	DatePicker mDatePicker = (DatePicker)findViewById(R.id.datepicker);
    	TimePicker mTimePicker = (TimePicker)findViewById(R.id.timepicker);
    	
    	Calendar c = Calendar.getInstance();
    	mYear = c.get(Calendar.YEAR);
    	mMonth = c.get(Calendar.MONTH);
    	mDay = c.get(Calendar.DAY_OF_MONTH);
    	mHour = c.get(Calendar.HOUR);
    	mMinute = c.get(Calendar.MINUTE);
    	
    	mDatePicker.init(mYear, mMonth, mDay, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				TimeDateActivity.this.mYear = year;
				TimeDateActivity.this.mMonth = monthOfYear;
				TimeDateActivity.this.mDay = dayOfMonth;
				
				showDate(mYear, mMonth, mDay, mHour, mMinute);
			}
    		
    	});
    	
    	mTimePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
    		public void onTimeChanged(TimePicker view, int hour, int minute) {
    			TimeDateActivity.this.mHour = hour;
    			TimeDateActivity.this.mMinute = minute;
    			showDate(mYear, mMonth, mDay, mHour, mMinute);
    		}
        });
    }
    
	public void showDate(int year, int month, int day, int hour, int minute) {
		EditText show = (EditText)findViewById(R.id.edittext);
		show.setText("the time of buying this book: " + year + " : " + (month + 1) + " : " + day + " : " + hour + " : " + minute );
	}
}
