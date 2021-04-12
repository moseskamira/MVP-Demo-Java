package com.team295.mvpdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.team295.mvpdemo.R;
import com.team295.mvpdemo.model.GithubUser;
import com.team295.mvpdemo.model.GithubUserResponse;
import com.team295.mvpdemo.presenter.GithubPresenter;
import com.team295.mvpdemo.service.contractor.GithubUserView;

public class MainActivity extends AppCompatActivity implements GithubUserView {
    private GithubPresenter githubPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        githubPresenter = new GithubPresenter();
        loadUsers();

    }

    private void loadUsers() {
        githubPresenter.fetchGithubUsers(this);
    }


    @Override
    public void allGithubUsers(GithubUserResponse response) {
        for (GithubUser githubUser : response.getGithubUsers()) {
            Log.d("USERS", githubUser.getUserName());
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}