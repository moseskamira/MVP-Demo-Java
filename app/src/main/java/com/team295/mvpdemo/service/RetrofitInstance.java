package com.team295.mvpdemo.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static String BASE_URL = "https://api.github.com/";

    private static Retrofit retrofitInstance;

    private static Retrofit returnRetrofitInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }

    public static ApiService returnApiService() {
       return returnRetrofitInstance().create(ApiService.class);
    }
}
