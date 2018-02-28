package com.zufaralam02.sempoasip.Parent.Home.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zufaralam02.sempoasip.Parent.Home.Fragments.FragmentChildHome;
import com.zufaralam02.sempoasip.Parent.Home.Fragments.FragmentChildLocation;

import java.util.List;

/**
 * Created by user on 26/02/2018.
 */

public class AdapterChildLocation extends FragmentPagerAdapter {
    List<String[]> listChild;

    public List<String[]> getListChild() {
        return listChild;
    }

    public void setListChild(List<String[]> listChild) {
        this.listChild = listChild;
    }

    public AdapterChildLocation(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentChildLocation.newInstance(position, listChild.get(position));
    }

    @Override
    public int getCount() {
        return listChild.size();
    }
}
