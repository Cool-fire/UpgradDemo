package com.example.upgraddemo.userInterest.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.chip.Chip;
import android.support.design.chip.ChipGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.upgraddemo.Home.ui.QuestionsListActivity;
import com.example.upgraddemo.R;
import com.example.upgraddemo.userInterest.adapter.ItemClickSupport;
import com.example.upgraddemo.userInterest.adapter.TagsAdapter;
import com.example.upgraddemo.userInterest.model.data.Item;
import com.example.upgraddemo.userInterest.model.interest_viewmodel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class UserInterestActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private TagsAdapter tagsAdapter;
    private ChipGroup chipGroup;
    private List<String> positions = new ArrayList<>();
    private Button submitBttn;
    private SharedPreferences shref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinterest);
        setupViews();
        interest_viewmodel model = ViewModelProviders.of(this).get(interest_viewmodel.class);
        model.init();
        model.getTags().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(final List<Item> items) {

                submitBttn.setVisibility(View.VISIBLE);
                tagsAdapter = new TagsAdapter(items);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerview.setLayoutManager(layoutManager);
                recyclerview.setItemAnimator(new DefaultItemAnimator());
                recyclerview.setAdapter(tagsAdapter);

                ItemClickSupport.addTo(recyclerview).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, final int position, View v) {

                        final Chip chip = getChip(position,items);
                        final String Text = chip.getText().toString();
                        if(!positions.contains(Text) && positions.size() <= 3)
                        {
                            chipGroup.addView(chip);
                            positions.add(Text);
                            chip.setOnCloseIconClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    chipGroup.removeView(chip);
                                    positions.remove(Text);
                                }
                            });
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Can't Select more than four tags or same tag", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        submitBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(positions.size() != 0){
                    saveTags();
                    Intent intent = new Intent(UserInterestActivity.this, QuestionsListActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Atleast one Tag must be selected",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void saveTags() {
        String key = getString(R.string.key);
        shref = getApplicationContext().getSharedPreferences("saveTags",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(positions);
        editor = shref.edit();
        editor.remove(key).apply();
        editor.putString(key, json);
        editor.commit();
    }

    private Chip getChip(int position, List<Item> items) {
        Chip chip = new Chip(this);
        chip.setText(items.get(position).getName());
        chip.setCloseIconVisible(true);
        chip.setChipBackgroundColorResource(R.color.orange);
        chip.setTextAppearanceResource(R.style.ChipTextStyle);
        chip.setElevation(15);
        return chip;
    }

    private void setupViews() {
        recyclerview = findViewById(R.id.recyclerview);
        chipGroup = findViewById(R.id.entry_chip_group);
        submitBttn = findViewById(R.id.submit_Bttn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Uri uri = getIntent().getData();
        if (uri != null) {
            String access = getResources().getString(R.string.access_token);
            String code = uri.getFragment().replace("access_token=","");
            if(!code.isEmpty()){
                shref = getApplicationContext().getSharedPreferences("saveAccessToken",Context.MODE_PRIVATE);
                editor = shref.edit();
                editor.remove(access).apply();
                editor.putString(access, code);
                editor.commit();
                //Toast.makeText(getApplicationContext(),"succesfully saved Token "+code,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
