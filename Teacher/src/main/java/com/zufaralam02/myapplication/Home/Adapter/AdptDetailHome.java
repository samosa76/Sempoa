package com.zufaralam02.myapplication.Home.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.myapplication.Home.Model.MDetailHeader;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/8/2018.
 */

public class AdptDetailHome extends BaseRecyclerAdapter {

    public ArrayList<MDetailHeader> getmDetailHeaders() {
        return mDetailHeaders;
    }

    public AdptDetailHome(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    public void setmDetailHeaders(ArrayList<MDetailHeader> mDetailHeaders) {
        this.mDetailHeaders = mDetailHeaders;
    }

    ArrayList<MDetailHeader> mDetailHeaders = new ArrayList<>();

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

        final AdptDetailHome.Holder holder = (AdptDetailHome.Holder) objectHolder;
        final MDetailHeader mDetailHeader = (MDetailHeader) getItem(position);

        holder.tvNamaHome.setText(mDetailHeader.getStudentName());
        holder.tvFoundation.setText(mDetailHeader.getFoundation());

        if (!mDetailHeader.isActive()) {
            holder.llDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.llButton.setVisibility(View.VISIBLE);
                }
            });
        } else {
            holder.llDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.llButton.setVisibility(View.GONE);
                }
            });
        }
    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    private class Holder extends RecyclerView.ViewHolder {
        TextView tvNamaHome, tvFoundation;
        LinearLayout llDetail, llButton;

        public Holder(View v) {
            super(v);

            tvNamaHome = (TextView) v.findViewById(R.id.tvNameStudent);
            tvFoundation = (TextView) v.findViewById(R.id.tvFoundationStudent);
            llDetail = (LinearLayout) v.findViewById(R.id.llDetailHome);
            llButton = (LinearLayout) v.findViewById(R.id.llButtonHide);

        }
    }
}
