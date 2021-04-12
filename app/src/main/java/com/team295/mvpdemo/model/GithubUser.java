package com.team295.mvpdemo.model;

import com.google.gson.annotations.SerializedName;

public class GithubUser {
    @SerializedName("avatar_url")
    String  profileImage;

    @SerializedName("login")
    String  userName;

    @SerializedName("html_url")
    String  profile;

    @SerializedName("company")
    String organization;


    public GithubUser(String profileImage, String userName, String profile, String organization) {
        this.profileImage = profileImage;
        this.userName = userName;
        this.profile = profile;
        this.organization = organization;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "profileImage='" + profileImage + '\'' +
                ", userName='" + userName + '\'' +
                ", profile='" + profile + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}
