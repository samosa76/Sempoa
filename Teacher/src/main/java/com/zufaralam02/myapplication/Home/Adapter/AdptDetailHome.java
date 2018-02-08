package com.zufaralam02.myapplication.Home.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.myapplication.Home.Model.MDetailHome;
import com.zufaralam02.myapplication.Profile.Fragment.Model.MReward;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/8/2018.
 */

public class AdptDetailHome extends BaseRecyclerAdapter {

    public ArrayList<MDetailHome> getmDetailHomes() {
        return mDetailHomes;
    }
    public AdptDetailHome(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    public void setmDetailHomes(ArrayList<MDetailHome> mDetailHomes) {
        this.mDetailHomes = mDetailHomes;
    }

    ArrayList<MDetailHome>mDetailHomes= new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdptDetailHome.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {

        AdptDetailHome.Holder holder = (AdptDetailHome.Holder)objectHolder;
        final MDetailHome mDetailHome = (MDetailHome)getItem(position);

        holder.tvNamaHome.setText(mDetailHome.getStudentName());
        holder.tvFoundation.setText(mDetailHome.getFoundation());
    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    private class Holder extends RecyclerView.ViewHolder {
        TextView tvNamaHome,tvFoundation;
        public Holder(View v) {
            super(v);

            tvNamaHome = (TextView)v.findViewById(R.id.tvNameStudent);
            tvFoundation = (TextView)v.findViewById(R.id.tvFoundationStudent);

        }
    }
}
