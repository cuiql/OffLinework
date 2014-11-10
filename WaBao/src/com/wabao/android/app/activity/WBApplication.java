package com.wabao.android.app.activity;

import android.app.Application;

import com.wabao.android.app.util.AppUtils;

public class WBApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(getApplicationContext());
    }
}
