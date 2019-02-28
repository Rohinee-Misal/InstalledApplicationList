package com.rohinee.ganesh.socialaddictionfree;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView InstalledApp=(ListView)findViewById(R.id.applist);
        List<ApplicationList> applications=getInstalledApp();
      MyAdapter myAdapter=new MyAdapter(MainActivity.this,applications);
        InstalledApp.setAdapter(myAdapter);


    }

    private List<ApplicationList> getInstalledApp() {
       List<ApplicationList> list= new ArrayList<ApplicationList>();
        List<PackageInfo> packs=getPackageManager().getInstalledPackages(0);
        for(int i=0;i<packs.size();i++){
            PackageInfo p=packs.get(i);
            if((isSystemPackage(p) == false)){
                String appName=p.applicationInfo.loadLabel(getPackageManager()).toString();
                Drawable icon=p.applicationInfo.loadIcon(getPackageManager());
                list.add(new ApplicationList(appName,icon));
            }
        }
       return  list;
    }
    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true : false;
    }
}
