package com.jb.rxretrofit.presenters;

import android.content.Context;
import android.util.Log;

import com.jb.rxretrofit.RxRetrofit;
import com.jb.rxretrofit.services.GithubService;
import com.jb.rxretrofit.views.BaseView;
import com.jb.rxretrofit.views.MainActivityInteractor;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by josep on 16/10/2016.
 */

public class MainActivityPresenter implements BaseView<MainActivityInteractor> {

    private static final String TAG = MainActivityPresenter.class.getSimpleName();

    private Context mContext;
    private MainActivityInteractor mView;
    private CompositeSubscription subscription;

    @Inject
    GithubService githubService;

    @Inject
    public MainActivityPresenter(Context context) {
        ((RxRetrofit) context.getApplicationContext()).getRxRetrofitComponents().inject(this);

        this.mContext = context;

        subscription = new CompositeSubscription();
    }

    @Override
    public void setView(MainActivityInteractor view) {
        this.mView = view;
    }

    public void getMyRepos() {
        subscription.add(githubService.getMyRepos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(repos -> mView.showRepos(repos), this::errorRepos)
        );
    }
    private void errorRepos(Throwable throwable) {
        Log.e(TAG, throwable.getLocalizedMessage());
    }


}
