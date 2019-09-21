package com.fsx.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Create by Fang ShiXian
 * on 2019/9/20
 */
public class MyApplication extends Application {

    private static Context mContext;
    private static MyApplication mApplication;

    public synchronized static MyApplication getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        mContext = this.getApplicationContext();
        mApplication = this;
        super.onCreate();

    }

    public static Context getAppContext() {
        return mContext;
    }
}
