package com.team295.mvpdemo.service;

import com.team295.mvpdemo.model.GithubUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("search/users?q=type:User+location:Nairobi+language:JAVA")
    Call<GithubUserResponse> fetchAllGithubUsers();


}
