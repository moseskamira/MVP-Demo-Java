package com.team295.mvpdemo.presenter;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.team295.mvpdemo.model.GithubUser;
import com.team295.mvpdemo.model.GithubUserResponse;
import com.team295.mvpdemo.service.ApiService;
import com.team295.mvpdemo.service.RetrofitInstance;
import com.team295.mvpdemo.service.contractor.GithubUserView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {
    private ApiService apiService = RetrofitInstance.returnApiService();
    private static GithubPresenter githubPresenterInstance;
    private static MutableLiveData<GithubUserResponse> githubUserResponseMutableLiveData;

    public static GithubPresenter returnPresenterInstance() {
        githubUserResponseMutableLiveData = new MutableLiveData<>();

        if (githubPresenterInstance == null) {
            githubPresenterInstance = new GithubPresenter();
        }
        return githubPresenterInstance;
    }

    public void fetchGithubUsers(final GithubUserView githubUserView) {
        apiService.fetchAllGithubUsers().enqueue(new Callback<GithubUserResponse>() {
            @Override
            public void onResponse(@NonNull Call<GithubUserResponse> call,
                                   @NonNull Response<GithubUserResponse> response) {
                if (response.body() != null) {
                    githubUserResponseMutableLiveData.postValue(response.body());
                    githubUserView.allGithubUsers(githubUserResponseMutableLiveData);
                }
            }

            @Override
            public void onFailure(@NonNull Call<GithubUserResponse> call, @NonNull Throwable t) {

            }
        });

    }

    public void fetchSingleUser(String username, final GithubUserView githubUserView) {
        apiService.searchUser(username).enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(@NonNull Call<GithubUser> call, @NonNull Response<GithubUser> response) {
                if (response.body() != null) {
                    githubUserView.singleGithubUser(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<GithubUser> call, @NonNull Throwable t) {

            }
        });
    }
}
