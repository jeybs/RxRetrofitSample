package com.jb.rxretrofit.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by josep on 16/10/2016.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Activity activity;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(getActivityLayout());
        ButterKnife.bind(this);
    }


    @LayoutRes
    protected abstract int getActivityLayout();
}
