package org.crazyandroid.launcher;

import org.crazyandroid.sample.R;

import android.os.Bundle;
import android.preference.PreferenceActivity;
public class PreferencesActivity extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	addPreferencesFromResource(R.xml.preferences);
    }
}
