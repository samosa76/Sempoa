package com.zufaralam02.myapplication.Home.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;
import com.zufaralam02.myapplication.Home.Model.MHome;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/5/2018.
 */

public class AHome extends BaseRecyclerAdapter{

    public ArrayList<MHome> getModelNotification() {
        return mHome;
    }

    public AHome(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }
    public void setmHome(ArrayList<MHome> modelNotification) {
        this.mHome = modelNotification;
    }
    ArrayList<MHome> mHome;
    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AHome.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        AHome.Holder holder = (AHome.Holder) objectHolder;
        final MHome modelNotification = (MHome) getItem(position);

        holder.tvTitleNotification.setText(modelNotification.getTitleNotif());
        holder.tvDetailNotification.setText(modelNotification.getDetailNotif());
    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }
    private class Holder extends RecyclerView.ViewHolder {
        TextView tvTitleNotification, tvDetailNotification, tvTimeNotification;
        ImageView ivNotification;
        LinearLayout linearNotif;

        public Holder(View v) {
            super(v);

            tvTitleNotification = v.findViewById(R.id.tvName);
            tvDetailNotification = v.findViewById(R.id.tvDate);
            tvTimeNotification = v.findViewById(R.id.tvTimeNotification);
            ivNotification = v.findViewById(R.id.ivNotification);
            linearNotif = v.findViewById(R.id.linearNotif);

        }
    }
}
