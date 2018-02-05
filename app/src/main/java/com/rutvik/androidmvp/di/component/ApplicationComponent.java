package com.rutvik.androidmvp.di.component;

import android.app.Application;

import android.content.Context;


import com.rutvik.androidmvp.AndroidMVP;
import com.rutvik.androidmvp.data.DataManager;
import com.rutvik.androidmvp.data.DbHelper;
import com.rutvik.androidmvp.data.SharedPrefsHelper;
import com.rutvik.androidmvp.di.ApplicationContext;
import com.rutvik.androidmvp.di.module.ApplicationModule;
import com.rutvik.androidmvp.di.module.RetrofitModule;
import com.rutvik.androidmvp.network.Service;
import com.rutvik.androidmvp.ui.home.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


/**
 * Created by Rutvik Bhatt on 2/2/18.
 */

@Singleton
@Component(modules = {ApplicationModule.class,RetrofitModule.class})

public interface ApplicationComponent {

    void inject(AndroidMVP wmtMVP);

    void inject(Service service);

    void inject(HomeActivity activity);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

    Retrofit getRetrofit();
}
