package com.rutvik.androidmvp.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


import com.rutvik.androidmvp.di.ApplicationContext;
import com.rutvik.androidmvp.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rutvik Bhatt on 2/2/18.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "wmt-mvp.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 1;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }


}
