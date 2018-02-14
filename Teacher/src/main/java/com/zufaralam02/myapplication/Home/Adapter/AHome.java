package com.zufaralam02.myapplication.Home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;
import com.zufaralam02.myapplication.Home.Activity.DetailHome;
import com.zufaralam02.myapplication.Home.Model.MHome;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/5/2018.
 */

public class AHome extends BaseRecyclerAdapter {

    public ArrayList<MHome> getModelNotification() {
        return mHome;
    }

    public AHome(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    public void setmHome(ArrayList<MHome> modelNotification) {
        this.mHome = modelNotification;
    }

    ArrayList<MHome> mHome = new ArrayList<>();

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

        holder.tvName.setText(modelNotification.getNameHome());
        holder.tvDate.setText(modelNotification.getDateHome());
        holder.cvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getContext(), DetailHome.class);
                a.putExtra("name",modelNotification.getNameHome());
                a.putExtra("da",modelNotification.getDateHome());
                getContext().startActivity(a);
            }
        });

    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    private class Holder extends RecyclerView.ViewHolder {
        TextView tvName, tvDate;

        CardView cvHome;

        public Holder(View v) {
            super(v);

            tvName = v.findViewById(R.id.tvName);
            tvDate = v.findViewById(R.id.tvDate);
            cvHome = v.findViewById(R.id.cvHome);

        }
    }
}
