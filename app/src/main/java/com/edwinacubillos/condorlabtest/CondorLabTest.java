package com.edwinacubillos.condorlabtest;

import android.app.Application;
import android.content.Context;

public class CondorLabTest extends Application {

    private static Context mContext;

    public static Context getAppContext() {
        return mContext;
    }

    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
