package com.example.upgraddemo.Home.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.upgraddemo.Home.model.data.hot.Item;
import com.example.upgraddemo.Home.model.data.hot.QuestionsList;

import com.example.upgraddemo.Home.model.service.DataService;
import com.example.upgraddemo.Home.model.service.RetrofitClientInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class home_repository {

//    private final hotItemDao hotDao;
//
//    public home_repository(Application application) {
//
//        hotItemDatabase hotDatabase = hotItemDatabase.getInstance(application);
//        hotDao = hotDatabase.hotDao();
//    }

    public LiveData<List<Item>> getHotQuestions(String Tag){
        final MutableLiveData<List<Item>> allhotquestions = new MutableLiveData<>();

        DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);


        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("sort", "hot");
        paramsMap.put("site", "stackoverflow");
        paramsMap.put("pagesize","100");
        paramsMap.put("tagged",Tag);
        paramsMap.put("order","desc");



        Call<QuestionsList> call = service.getHotItems(paramsMap);
        call.enqueue(new Callback<QuestionsList>() {
            @Override
            public void onResponse(Call<QuestionsList> call, Response<QuestionsList> response) {
                if(response.isSuccessful()){
                    allhotquestions.setValue(response.body().getItems());
                }
                Log.d("code","code: "+response.code());
            }

            @Override
            public void onFailure(Call<QuestionsList> call, Throwable t) {
                Log.d("Error","Error Occurred");
            }
        });
        return allhotquestions;
    }

    public LiveData<List<com.example.upgraddemo.Home.model.data.week.Item>> getWeekQuestions(String Tag){
        final MutableLiveData<List<com.example.upgraddemo.Home.model.data.week.Item>> allWeekquestions = new MutableLiveData<>();

        DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);


        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("sort", "week");
        paramsMap.put("site", "stackoverflow");
        paramsMap.put("tagged",Tag);
        paramsMap.put("pagesize","100");
        paramsMap.put("order","desc");

        Call<com.example.upgraddemo.Home.model.data.week.QuestionsList> call = service.getWeekItems(paramsMap);
        call.enqueue(new Callback<com.example.upgraddemo.Home.model.data.week.QuestionsList>() {
            @Override
            public void onResponse(Call<com.example.upgraddemo.Home.model.data.week.QuestionsList> call, Response<com.example.upgraddemo.Home.model.data.week.QuestionsList> response) {
                if(response.isSuccessful()){
                    allWeekquestions.setValue(response.body().getItems());
                }
                Log.d("code","code: "+response.code());
            }

            @Override
            public void onFailure(Call<com.example.upgraddemo.Home.model.data.week.QuestionsList> call, Throwable t) {
                Log.d("Error","Error Occurred");

            }
        });
        return allWeekquestions;
    }

}
