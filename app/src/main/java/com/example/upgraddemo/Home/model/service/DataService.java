package com.example.upgraddemo.Home.model.service;

import com.example.upgraddemo.Home.model.data.hot.QuestionsList;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface DataService {

    @GET("2.2/questions")
    Call<QuestionsList> getHotItems(@QueryMap Map<String, String> paramsMap);


    @GET("2.2/questions")
    Call<com.example.upgraddemo.Home.model.data.week.QuestionsList> getWeekItems(@QueryMap Map<String, String> paramsMap);
}

