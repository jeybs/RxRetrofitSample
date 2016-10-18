package com.jb.rxretrofit;

import com.jb.rxretrofit.activities.MainActivity;
import com.jb.rxretrofit.presenters.MainActivityPresenter;
import com.jb.rxretrofit.presenters.PresenterModules;
import com.jb.rxretrofit.services.ApiModules;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by josep on 16/10/2016.
 */

@Singleton
@Component(modules = {RxRetrofitModules.class, PresenterModules.class, ApiModules.class})
public interface RxRetrofitComponents {

    //region Activities
    void inject(MainActivity activity);
    //endregion


    //region Presenters
    void inject(MainActivityPresenter presenter);
    //endregion
}
