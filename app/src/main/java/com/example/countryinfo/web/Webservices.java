package com.example.countryinfo.web;


import com.example.countryinfo.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Webservices {
    private final Cache cache;
    private final File httpCacheDirectory;
    private WebApi webApi;
    private static Webservices mInstance;
    private Gson gson;

    public Webservices(File cacheDir) {
        httpCacheDirectory = new File(cacheDir, "offlineCache");

        //10 MB
        cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        mInstance = this;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .callTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();
        gson = new GsonBuilder().setLenient().create();
        webApi = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(WebApi.class);
    }

    public static Webservices getInstance() {
        return mInstance;
    }
    public WebApi getWebApi(){
        return webApi;
    }

}
