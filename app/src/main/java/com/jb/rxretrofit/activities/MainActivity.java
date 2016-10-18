package com.jb.rxretrofit.activities;

import android.os.Bundle;
import android.util.Log;

import com.jb.rxretrofit.R;
import com.jb.rxretrofit.RxRetrofit;
import com.jb.rxretrofit.presenters.MainActivityPresenter;
import com.jb.rxretrofit.views.MainActivityInteractor;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainActivityInteractor {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;

        ((RxRetrofit) activity.getApplicationContext()).getRxRetrofitComponents().inject(this);

        mainActivityPresenter.setView(this);
        mainActivityPresenter.getMyRepos();
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showRepos(String repos) {
        Log.e(TAG, repos);
    }
}
