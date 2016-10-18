package com.jb.rxretrofit;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.jb.rxretrofit.presenters.PresenterModules;
import com.jb.rxretrofit.services.ApiModules;

/**
 * Created by josep on 16/10/2016.
 */

public class RxRetrofit extends Application {

    private RxRetrofitComponents rxRetrofitComponents;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);

        rxRetrofitComponents = DaggerRxRetrofitComponents.builder()
                .rxRetrofitModules(new RxRetrofitModules(this))
                .presenterModules(new PresenterModules(this))
                .apiModules(new ApiModules(this, BuildConfig.BASE_URL))
                .build();
    }

    public RxRetrofitComponents getRxRetrofitComponents() {
        return rxRetrofitComponents;
    }

}
