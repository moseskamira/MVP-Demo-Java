package com.team295.mvpdemo.service.contractor;

import com.team295.mvpdemo.model.GithubUser;
import com.team295.mvpdemo.model.GithubUserResponse;

public interface GithubUserView {
    void allGithubUsers(GithubUserResponse response);

    void singleGithubUser(GithubUser githubUser);

}
