package com.zufaralam02.sempoasip.Parent.Home.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

import com.zufaralam02.sempoasip.Parent.Home.Fragments.FragmentChildHome;
import com.zufaralam02.sempoasip.Parent.Home.Models.ListMurid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 22/01/2018.
 */

public class AdapterChildHome extends FragmentPagerAdapter {
    private ArrayList<String> listMurid;

    public ArrayList<String> getListMurid() {
        return listMurid;
    }

    public void setListMurid(ArrayList<String> listMurid) {
        this.listMurid = listMurid;
    }

    public AdapterChildHome(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        return FragmentChildHome.newInstance(position, listMurid.get(position));
        return FragmentChildHome.newInstance(position, listMurid.get(position));
    }

    @Override
    public int getCount() {
        return listMurid.size();
    }

}
