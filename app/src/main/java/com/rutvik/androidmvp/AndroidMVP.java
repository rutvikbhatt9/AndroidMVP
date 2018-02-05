package com.rutvik.androidmvp;

import android.app.Application;
import android.content.Context;

import com.rutvik.androidmvp.di.component.ApplicationComponent;
import com.rutvik.androidmvp.di.component.DaggerApplicationComponent;
import com.rutvik.androidmvp.di.module.ApplicationModule;
import com.rutvik.androidmvp.di.module.RetrofitModule;

/**
 * Created by rutvik on 5/2/18.
 */

public class AndroidMVP extends Application {
    ApplicationComponent applicationComponent;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent= DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .retrofitModule(new RetrofitModule(BASE_URL))
                .build();

    }

    public static AndroidMVP get(Context context) {
        return (AndroidMVP) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
