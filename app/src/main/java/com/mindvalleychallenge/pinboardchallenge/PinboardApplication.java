package com.mindvalleychallenge.pinboardchallenge;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;


import com.mindvalley.universaldownloader.lib.UniversalDownloader;
import com.mindvalleychallenge.pinboardchallenge.pinboard.utils.AppConstants;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by MuhammadMahmoor on 8/15/17.
 */

public class PinboardApplication extends Application {

    public static Realm realm;
    public static Context context;
    static UniversalDownloader universalDownloader;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int availableMemory = activityManager.getMemoryClass(); // Available memory for app in system in Bytes
        int maxCacheSize =   availableMemory / 8;
        universalDownloader = UniversalDownloader.getInstance(this, maxCacheSize);

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(AppConstants.DB_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
    }

    public static UniversalDownloader getUniversalDownloader() {
        return universalDownloader;
    }
}
