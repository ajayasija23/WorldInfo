package com.example.countryinfo;

import android.app.Application;

import com.example.countryinfo.web.Webservices;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new Webservices(getCacheDir());
    }
}
