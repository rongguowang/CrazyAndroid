package org.crazyandroid.sample;
 
import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
public class TableLayoutActivity extends Activity {

    private Button launcherOpen;
    private Button activityOpen;
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablelayout);
        activityOpen = (Button)findViewById(R.id.ok14);
        activityOpen.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                ComponentName cn = new ComponentName("com.miui.gallery", "com.miui.gallery.app.Gallery");
                intent.setComponent(cn);
                startActivity(intent);
            }
        });
        launcherOpen = (Button)findViewById(R.id.ok15);
        launcherOpen.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
//                Intent intent= new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_LAUNCHER);
//                ComponentName cn = new ComponentName("com.android.launcher2", ".Launcher");
//                intent.setComponent(cn);
//                startActivity(intent);
                try {
                    String pkg = "com.android.launcher";
                    PackageInfo pi = getPackageManager().getPackageInfo(pkg, 0);
                    Intent resolveIntent = new Intent(Intent.ACTION_MAIN);
                    resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                    resolveIntent.setPackage(pi.packageName);

                    List<ResolveInfo> apps = getPackageManager().queryIntentActivities(resolveIntent, 0);
                    ResolveInfo ri = apps.iterator().next();
                    if (ri != null) {
                        String pkgName = ri.activityInfo.packageName;
                        String className = ri.activityInfo.name;
                        System.out.println("TalbeLayoutAcitvity: " + "package = " + pkgName + " class = " + className);

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_LAUNCHER);
                        ComponentName cn = new ComponentName(pkgName, className);
                        intent.setComponent(cn);
                        startActivity(intent);
                    }
                } catch (NameNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
     }
 }
