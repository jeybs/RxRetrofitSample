package com.jb.rxretrofit.services;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by josep on 16/10/2016.
 */

public interface GithubService {

    @GET("users/jeybs/repos")
    Observable<String> getMyRepos();

}
