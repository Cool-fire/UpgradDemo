package com.example.upgraddemo.Home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.upgraddemo.Home.ui.TabFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    String tag;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, String tag) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.tag = tag;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment tab = TabFragment.newInstance(tag,"hot");
                return tab;
            case 1:
                tab = TabFragment.newInstance(tag,"week");
                return tab;
            default:
                return TabFragment.newInstance(tag, "hot");
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}