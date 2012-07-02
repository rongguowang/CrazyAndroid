package org.crazyandroid.launcher;

import java.util.ArrayList;
import java.util.List;

import org.crazyandroid.sample.R;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;

public class PreferedQueryActivity extends Activity{
    Intent intent = new Intent();
    PackageManager mPackageManager;
    List<ResolveInfo> mInfoList;
    TextView tx;
    TextView tx2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdraglayout);

        tx = (TextView)findViewById(R.id.textview3);
        tx2 = (TextView)findViewById(R.id.textview4);
        intent.setAction("android.intent.action.SET_WALLPAPER");
        mPackageManager = this.getPackageManager();

        mInfoList = mPackageManager.queryIntentActivities(intent, 0);
        if(mInfoList == null) {
            mInfoList = new ArrayList<ResolveInfo>();
        }

        StringBuffer sb = new StringBuffer();
        for (ResolveInfo info : mInfoList) {
            System.out.println("packageinfo:" + info.activityInfo.packageName);
            sb.append(info.activityInfo.packageName);
            sb.append("\n");
        }
        tx.setText(sb);

        sb.delete(0, sb.length());
        Resources res = getResources();
        Configuration config = res.getConfiguration();
        DisplayMetrics dm = res.getDisplayMetrics();
        sb.append("Configuration.screenHeightDp = " + config.screenHeightDp + "\n");
        sb.append("Configuration.screenWidthDp = " + config.screenWidthDp + "\n");
        sb.append("config.smallestScreenWidthDp = " + config.smallestScreenWidthDp + "\n");
        sb.append("DisplayMetrics.density = " + dm.density+ "\n");
        sb.append("DisplayMetrics.densityDpi = " + dm.densityDpi+ "\n");
        sb.append("DisplayMetrics.heightPixels = " + dm.heightPixels+ "\n");
        sb.append("DisplayMetrics.scaledDensity = " + dm.scaledDensity + "\n");
        sb.append("DisplayMetrics.widthPixels = " + dm.widthPixels + "\n");
        sb.append("DisplayMetrics.xdpi = " + dm.xdpi + "\n");
        sb.append("DisplayMetrics.ydpi = " + dm.ydpi + "\n");
        tx2.setText(sb);
    }
}
