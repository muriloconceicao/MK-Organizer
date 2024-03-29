package com.example.mkorganizer.utils;

import android.app.Application;
import android.content.Context;

public class AppContext extends Application {

    private static Application sApplication;

    private static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }
}