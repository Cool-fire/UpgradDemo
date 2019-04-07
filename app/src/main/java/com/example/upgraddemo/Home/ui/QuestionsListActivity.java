package com.example.upgraddemo.Home.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.upgraddemo.Home.adapter.PagerAdapter;
import com.example.upgraddemo.Home.model.home_viewmodel;
import com.example.upgraddemo.Home.model.data.hot.Item;
import com.example.upgraddemo.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListActivity extends AppCompatActivity {

    private List<String> Tags;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ActionBar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

                            case 0: {
                                setupViewPager(Tags.get(0));
                                actionbar.setTitle(Tags.get(0));
                                break;
                            }

                            case 1: {
                                setupViewPager(Tags.get(1));
                                actionbar.setTitle(Tags.get(1));

                                break;
                            }

                            case 2: {
                                setupViewPager(Tags.get(2));
                                actionbar.setTitle(Tags.get(2));

                                break;
                            }
                            case 3:{
                                setupViewPager(Tags.get(3));
                                actionbar.setTitle(Tags.get(3));

                                break;
                            }
                        }
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });

        final Menu menu = navigationView.getMenu();
        Tags = loadcacheList(getApplicationContext());
        for(int i = 0 ; i < Tags.size() ; i++){
            menu.add(0,i,0,Tags.get(i).toString());
        }

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Hot"));
        tabLayout.addTab(tabLayout.newTab().setText("Week"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        setupViewPager(Tags.get(0));
        actionbar.setTitle(Tags.get(0));

    }

    private void setupViewPager(final String Tag) {

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), Tag);
        viewPager.setAdapter(adapter);
        Toast.makeText(getApplicationContext(),Tag,Toast.LENGTH_SHORT).show();
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<String> loadcacheList(Context context) {

        List<String> Tags = new ArrayList<>();
        SharedPreferences mPrefs = context.getSharedPreferences("saveTags", context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString(getString(R.string.key), "");
        if(json.isEmpty()){
            Tags = new ArrayList<>();
        }else {

            Tags = gson.fromJson(json,
                    new TypeToken<List<String>>(){}.getType());

        }
       return Tags;
    }
}
