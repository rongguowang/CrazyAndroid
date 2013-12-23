package org.crazyandroid.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class PropertyNotifyService extends Service {
	private String mProperty1 = "property1";
	private String mProperty2 = "property2";
	private Property mProperty3 = new Property();
	private String TAG = "PropertyNotifyService";
	private IBinder mBinder = new LocalBinder();
	private List<onPropertyChangedListener> mList = null;

	public void onCreate() {
		super.onCreate();
		mList = new ArrayList<onPropertyChangedListener>();
		Log.i(TAG, "onCreate");
	}
	
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "onStartCommand");
		return this.START_STICKY;
	}
	
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		Log.i(TAG, "onBind");
		return mBinder;
	}
	
	public void onUnBind(Intent intent) {
		super.onUnbind(intent);
		Log.i(TAG, "onUnBind");
	}
	
	public void setProperty1(String prop1) {
		mProperty1 = prop1;
		Log.i(TAG, "setProperty1");
		for (int i = 0; i < mList.size(); i++) {
			mList.get(i).onPropertyChanged(this.getProperty1());
		}
	}
	
	public String getProperty1() {
		return mProperty1;
	}
	
	public void setProperty2(String prop2) {
		mProperty2 = prop2;
		Log.i(TAG, "setProperty2");
		Bundle bundle = new Bundle();
		bundle.putString("property2", mProperty2);
		Intent intent = new Intent("org.crazyandroid.basic.PropertyChangedSiganl");
		intent.putExtras(bundle);
		this.sendBroadcast(intent);
	}
	
	public String getProperty2() {
		return mProperty2;
	}
	
	public void setProperty3(String prop) {
		mProperty3.setProperty(prop);
	}
	
	public String getProperty3() {
		return mProperty3.getProperty();
	}
	
	public void setPropertyObserver(Observer observer) {
		mProperty3.addObserver(observer);
	}
	
	public class LocalBinder extends Binder {
		PropertyNotifyService getService() {
			return PropertyNotifyService.this;
		}
	}
	
	public interface onPropertyChangedListener {
		public void onPropertyChanged(String value);
	}
	
	public boolean registerChangeListener(onPropertyChangedListener listener) {
		if (mList == null) {
			mList = new ArrayList<onPropertyChangedListener>();
		}
		
		if (mList.contains(listener)) {
			return true;
		}
		
		return mList.add(listener);
	}
	
	public onPropertyChangedListener unregisterChangeListener(onPropertyChangedListener listener) {
		if (mList == null) {
			return null;
		}
		if (mList.contains(listener)) {
			int i = mList.indexOf(listener);
			return mList.remove(i);
		}
		return null;
	}
	
	public class Property extends Observable {
		private String mProperty = null;
		
		public void setProperty(String prop) {
			mProperty = prop;
			setChanged();
			notifyObservers();
		}
		
		public String getProperty() {
			return mProperty;
		}
	}
}
