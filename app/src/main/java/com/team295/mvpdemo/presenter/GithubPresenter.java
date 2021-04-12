package com.team295.mvpdemo.presenter;

import androidx.annotation.NonNull;

import com.team295.mvpdemo.model.GithubUserResponse;
import com.team295.mvpdemo.service.ApiService;
import com.team295.mvpdemo.service.RetrofitInstance;
import com.team295.mvpdemo.contractor.GithubUserView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {
    ApiService apiService = RetrofitInstance.returnApiService();

    public void fetchGithubUsers(final GithubUserView githubUserView) {
        apiService.fetchAllGithubUsers().enqueue(new Callback<GithubUserResponse>() {
            @Override
            public void onResponse(@NonNull Call<GithubUserResponse> call, @NonNull Response<GithubUserResponse> response) {
                if (response.body() != null) {
                   githubUserView.allGithubUsers(response.body());
                }

            }

            @Override
            public void onFailure(@NonNull Call<GithubUserResponse> call, @NonNull Throwable t) {

            }
        });

    }
}
