package com.zufaralam02.myapplication.Home.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.myapplication.Home.Pojo.AddStudent.Result;
import com.zufaralam02.myapplication.R;

import java.util.List;

/**
 * Created by User on 2/14/2018.
 */

public class AdapterAdd extends BaseRecyclerAdapter {
    public AdapterAdd(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdapterAdd.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        AdapterAdd.Holder holder = (AdapterAdd.Holder) objectHolder;
        Result result = (Result) getItem(position);

        holder.tvNama.setText(result.getNamaSiswa());
        holder.tvAlamat.setText(result.getAlamat());
        holder.tvKelas.setText(result.getLevel());
    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    private class Holder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat, tvKelas;

        public Holder(View v) {
            super(v);
            tvNama = (TextView) v.findViewById(R.id.tvAddNama);
            tvAlamat = (TextView) v.findViewById(R.id.tvAddAlamat);
            tvKelas = (TextView) v.findViewById(R.id.tvAddKelas);
        }
    }
}
