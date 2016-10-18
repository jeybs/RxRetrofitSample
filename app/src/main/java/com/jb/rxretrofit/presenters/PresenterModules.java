package com.jb.rxretrofit.presenters;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by josep on 16/10/2016.
 */

@Module
public class PresenterModules {

    final Application application;

    public PresenterModules(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenter(application.getApplicationContext());
    }

}
