package com.example.upgraddemo.Home.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.upgraddemo.Home.model.data.hot.Item;
import com.example.upgraddemo.Home.model.home_repository;

import java.util.List;

public class home_viewmodel extends ViewModel {

    private LiveData<List<Item>> hotQuestions;
    private LiveData<List<com.example.upgraddemo.Home.model.data.week.Item>> weekQuestions;
    private String hotTag = "";
    private String weekTag = "";

    public void init(String Tag){
        if (hotQuestions == null || hotTag != Tag ) {
            hotQuestions = new MutableLiveData<List<Item>>();
            loadHotQuestions(Tag);
            hotTag = Tag;
        }
        if(weekQuestions == null || weekTag != Tag){
            weekQuestions = new MutableLiveData<List<com.example.upgraddemo.Home.model.data.week.Item>>();
            loadweekQuestions(Tag);
            weekTag = Tag;
        }

    }

    private void loadweekQuestions(String tag) {
        weekQuestions = new home_repository().getWeekQuestions(tag);
    }

    public LiveData<List<com.example.upgraddemo.Home.model.data.week.Item>> getWeekQuestions() {return this.weekQuestions;}

    public LiveData<List<Item>> getHotQuestions() {
        return this.hotQuestions;
    }

    private void loadHotQuestions(String Tag) {
        hotQuestions = new home_repository().getHotQuestions(Tag);

    }

    public home_viewmodel() {
    }
}
