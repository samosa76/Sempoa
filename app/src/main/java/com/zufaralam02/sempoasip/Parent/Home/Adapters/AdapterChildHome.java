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
    public ArrayList<ListMurid> getListMurid() {
        return listMurid;
    }

    public void setListMurid(ArrayList<ListMurid> listMurid) {
        this.listMurid = listMurid;
    }

    ArrayList<ListMurid> listMurid;

    public AdapterChildHome(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

//        if (listChild.size() == 0) {
//            tvChildWallet.setText(listChild.indexOf(0));
//            tvChildRank.setText(listChild.indexOf(0));
//        } else if (listChild.size() == 1) {
//            tvChildWallet.setText(listChild.indexOf(1));
//            tvChildRank.setText(listChild.indexOf(1));
//        }

        return FragmentChildHome.newInstance(position, listMurid.get(position));
    }

    @Override
    public int getCount() {
        return listMurid.size();
    }

}
