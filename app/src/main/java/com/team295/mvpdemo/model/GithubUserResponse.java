package com.team295.mvpdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubUserResponse {

    @SerializedName("items")
    private ArrayList<GithubUser> githubUsers;

    public ArrayList<GithubUser> getGithubUsers() {
        return githubUsers;
    }

    public void setGithubUsers(ArrayList<GithubUser> githubUsers) {
        this.githubUsers = githubUsers;
    }
}
