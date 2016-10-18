package com.jb.rxretrofit.services;

import android.app.Application;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by josep on 16/10/2016.
 */

@Module
public class ApiModules {

    final Application application;
    final String baseUrl;


    public ApiModules(Application application, String baseUrl) {
        this.application = application;
        this.baseUrl = baseUrl;
    }

    @Singleton
    @Provides
    @Named("Api")
    OkHttpClient provideOkHttpClient() {
        return createApiClient();
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    public GithubService provideGithubService(@Named("Api") OkHttpClient client, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(new ToStringConverterFactory())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit.create(GithubService.class);
    }


    static OkHttpClient createApiClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.connectTimeout(20, TimeUnit.SECONDS);
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());

                return response;
            }
        });

        return builder.build();
    }
}
