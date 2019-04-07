package com.example.upgraddemo.userInterest.model.service;

import com.example.upgraddemo.userInterest.model.data.Item;
import com.example.upgraddemo.userInterest.model.data.TagsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("2.2/tags?pagesize=100&order=desc&sort=popular&site=stackoverflow")
    Call<TagsList> getItems();
}

