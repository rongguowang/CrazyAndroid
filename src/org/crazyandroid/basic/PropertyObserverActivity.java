package org.crazyandroid.basic;

import java.util.Observable;
import java.util.Observer;

import org.crazyandroid.sample.R;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

public class PropertyObserverActivity extends Activity implements Observer {
	private String TAG = "PropertyNotifyService";
	private Button mStartService = null;
	private Button mBindService = null;
	private Button mStopService = null;
	private Button mChangeViaListener = null;
	private Button mChangeViaIntent = null;
	private Button mChangeViaObservable = null;
	private EditText mTextViaListener = null;
	private EditText mTextViaIntent = null;
	private EditText mTextViaObservable = null;
	private PropertyNotifyService mNotifyService = null;
	private ServiceConnection mNotifyConnection = null;
	private PropertyNotifyService.onPropertyChangedListener mPropertyChangedListener = null;
	private PropertyChangedReceiver mPropertyChangedReceiver = null;
	private PropertyObserver mObserver = null;

    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.observerlayout);
    	
    	mObserver = new PropertyObserver(this.getApplicationContext());
    	
    	mStartService = (Button)findViewById(R.id.start_service);
    	mStartService.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(PropertyObserverActivity.this,
    					PropertyNotifyService.class);
    			startService(intent);
    		}

    	});
    	
    	mNotifyConnection = new ServiceConnection() {
			@Override
			public void onServiceConnected(ComponentName arg0,
					IBinder binder) {
				mNotifyService = ((PropertyNotifyService.LocalBinder)
						binder).getService();
			}
			@Override
			public void onServiceDisconnected(ComponentName arg0) {
				mNotifyService = null;
			}
    	};
    	
    	mBindService = (Button)findViewById(R.id.bind_service);
    	mBindService.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			//Intent intent = new Intent(PropertyObserverActivity.this,
    					//PropertyNotifyService.class);
    			Intent intent = new Intent("com.harman.ObserverPattern.NotifyService");
    			bindService(intent, mNotifyConnection, Context.BIND_AUTO_CREATE);
    		}
    	});
    	
    	mStopService = (Button)findViewById(R.id.stop_service);
    	mStopService.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Intent intent = new Intent(PropertyObserverActivity.this,
    					PropertyNotifyService.class);
    			stopService(intent);
    		}
    	});
    	
    	mChangeViaListener = (Button)findViewById(R.id.change_via_listener);
    	mTextViaListener = (EditText)findViewById(R.id.property1);
    	
        mPropertyChangedListener = new PropertyNotifyService.onPropertyChangedListener() {
			public void onPropertyChanged(String value) {					
				Toast.makeText(getApplication(), "Proerty1 changed to: " + value, Toast.LENGTH_LONG).show();;
			}
		};
		
    	mChangeViaListener.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			if ((mTextViaListener.getText() != null) && (mNotifyService != null)) {
    		    	mNotifyService.registerChangeListener(mPropertyChangedListener);
    				mNotifyService.setProperty1(mTextViaListener.getText().toString());
    				mNotifyService.unregisterChangeListener(mPropertyChangedListener);
    			}
    		}
    	});
    	
    	mChangeViaIntent = (Button)findViewById(R.id.change_via_intent);
    	mTextViaIntent = (EditText)findViewById(R.id.property2);
    	mChangeViaIntent.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			if ((mTextViaIntent.getText()!= null) && (mNotifyService != null)) {
    				mNotifyService.setProperty2(mTextViaIntent.getText().toString());
    			}
    		}
    	});

    	mPropertyChangedReceiver = new PropertyChangedReceiver();
    	
    	mChangeViaObservable = (Button)findViewById(R.id.change_via_observable);
    	mTextViaObservable = (EditText)findViewById(R.id.property3);
    	mChangeViaObservable.setOnClickListener( new OnClickListener() {
    		public void onClick(View v) {
    			if ((mTextViaIntent.getText() != null) && (mNotifyService != null)) {
    				Log.i(TAG, "mProperty.setProperty");
    				mNotifyService.setPropertyObserver(mObserver);
    				mNotifyService.setProperty3(mTextViaObservable.getText().toString());
    			}
    		}
    	});

    }
    
    public void onResume() {
    	super.onResume();
    	IntentFilter filter = new IntentFilter("org.crazyandroid.basic.PropertyChangedSiganl");
    	registerReceiver(mPropertyChangedReceiver, filter);
    }
    
    public void onPause() {
    	super.onPause();
    	unregisterReceiver(mPropertyChangedReceiver);
    } 

    public void onDestroy() {
    	super.onDestroy();
    	if (mChangeViaListener != null) {
    		mNotifyService.unregisterChangeListener(mPropertyChangedListener);
    	}
    	if (mNotifyService != null) {
    		mNotifyService.unbindService(mNotifyConnection);
    	}
    }
    
    private class PropertyChangedReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals("org.crazyandroid.basic.PropertyChangedSiganl")) {
				Log.i(TAG, "onReceive");
				Bundle bundle = intent.getExtras();
				Toast.makeText(context, "property2 changed to: " + bundle.getString("property2"), Toast.LENGTH_LONG).show();
			}
		}
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		Log.i(TAG, "Property Observer");
		
	}
	
	public class PropertyObserver implements Observer {
		private Context mContext = null;
		public PropertyObserver(Context context) {
			mContext = context;
		}
		public void update(Observable observable, Object data) {
			Toast.makeText(mContext, "property3 changed to: " + mNotifyService.getProperty3(), Toast.LENGTH_LONG).show();
		}
	}
}
