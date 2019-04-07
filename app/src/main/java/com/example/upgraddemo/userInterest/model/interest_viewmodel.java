package com.example.upgraddemo.userInterest.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.upgraddemo.userInterest.model.data.Item;

import java.util.List;

public class interest_viewmodel extends ViewModel {

    private LiveData<List<Item>> Tags;

    public void init(){
        if (Tags == null) {
            Tags = new MutableLiveData<List<Item>>();
            loadTags();
        }
    }
    public LiveData<List<Item>> getTags() {
        return this.Tags;
    }

    private void loadTags() {
        Tags = new interest_repository().getAllTags();
    }

    public interest_viewmodel() {
    }
}
