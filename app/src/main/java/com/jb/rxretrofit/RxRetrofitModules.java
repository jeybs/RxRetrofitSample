package com.jb.rxretrofit;

import android.app.Application;

import dagger.Module;

/**
 * Created by josep on 16/10/2016.
 */

@Module
public class RxRetrofitModules {

    final Application application;


    public RxRetrofitModules(Application application) {
        this.application = application;
    }



}
