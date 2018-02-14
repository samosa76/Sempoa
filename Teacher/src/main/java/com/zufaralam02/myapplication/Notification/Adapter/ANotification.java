package com.zufaralam02.myapplication.Notification.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;
import com.zufaralam02.myapplication.Notification.Activity.DetailNotif;
import com.zufaralam02.myapplication.Notification.Model.MNotif;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/5/2018.
 */

public class ANotification extends BaseRecyclerAdapter{

    public ArrayList<MNotif> getModelNotification() {
        return mNotif;
    }

    public ANotification(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }
    public void setModelNotification(ArrayList<MNotif> modelNotification) {
        this.mNotif = modelNotification;
    }
    ArrayList<MNotif>mNotif;
    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new ANotification.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        ANotification.Holder holder = (ANotification.Holder) objectHolder;
        final MNotif modelNotification = (MNotif) getItem(position);

        holder.tvTitleNotification.setText(modelNotification.getTitleNotif());
        holder.tvDetailNotification.setText(modelNotification.getDetailNotif());
        holder.tvTimeNotification.setText(modelNotification.getTimeNotif());
        Picasso.with(getContext()).load(modelNotification.getImageNotif()).into(holder.ivNotification);

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

            tvTitleNotification = v.findViewById(R.id.tvTitleNotification);
            tvDetailNotification = v.findViewById(R.id.tvDetailNotification);
            tvTimeNotification = v.findViewById(R.id.tvTimeNotification);
            ivNotification = v.findViewById(R.id.ivNotification);
            linearNotif = v.findViewById(R.id.linearNotif);

        }
    }
}
