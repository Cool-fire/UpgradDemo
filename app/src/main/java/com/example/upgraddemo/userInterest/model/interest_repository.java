package com.example.upgraddemo.userInterest.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.upgraddemo.userInterest.model.data.Item;
import com.example.upgraddemo.userInterest.model.data.TagsList;
import com.example.upgraddemo.userInterest.model.service.DataService;
import com.example.upgraddemo.userInterest.model.service.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class interest_repository {


    public interest_repository() {
    }

    public LiveData<List<Item>> getAllTags(){
        final MutableLiveData<List<Item>> allTags = new MutableLiveData<>();

        DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);
        Call<TagsList> call = service.getItems();
        call.enqueue(new Callback<TagsList>() {
            @Override
            public void onResponse(Call<TagsList> call, Response<TagsList> response) {
                if(response.isSuccessful()){
                    allTags.setValue(response.body().getItems());
                }
                else {
                    Log.d("Tag",response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<TagsList> call, Throwable t) {
                Log.d("Error","Error Occurred");
            }
        });
        return allTags;
    }
}
