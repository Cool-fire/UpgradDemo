package com.example.upgraddemo.Home.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.upgraddemo.Home.adapter.QuestionsAdapter;
import com.example.upgraddemo.Home.model.data.hot.Item;
import com.example.upgraddemo.Home.model.home_viewmodel;
import com.example.upgraddemo.R;

import java.util.List;


public class TabFragment extends Fragment {

    private String mTag;
    private String mPriority;
    private home_viewmodel model;
    private List<Item> hotQuestions;
    private List<com.example.upgraddemo.Home.model.data.week.Item> weekQuestions;
    private RecyclerView recyclerView;

    public static TabFragment newInstance(String tag, String priority) {
        TabFragment fragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", tag);
        bundle.putString("priority",priority);
        fragment.setArguments(bundle);
        return fragment;
    }

    public TabFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mTag = args.getString("tag");
            mPriority = args.getString("priority");
        }

        model = ViewModelProviders.of(this).get(home_viewmodel.class);
        model.init(mTag);
        if(mPriority == "hot"){
            model.getHotQuestions().observe(this, new Observer<List<Item>>() {
                @Override
                public void onChanged(@Nullable List<Item> items) {
                    hotQuestions = items;
                    if(hotQuestions != null){
                        QuestionsAdapter adapter = new QuestionsAdapter(hotQuestions,null,mPriority);
                        recyclerView.setAdapter(adapter);
                    }

                }
            });
        }
        else {
            model.getWeekQuestions().observe(this, new Observer<List<com.example.upgraddemo.Home.model.data.week.Item>>() {
                @Override
                public void onChanged(@Nullable List<com.example.upgraddemo.Home.model.data.week.Item> items) {
                    weekQuestions = items;
                    if(weekQuestions != null){
                        QuestionsAdapter adapter = new QuestionsAdapter(null,weekQuestions,mPriority);
                        recyclerView.setAdapter(adapter);
                    }
                }
            });
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.tab_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
