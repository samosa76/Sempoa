package com.zufaralam02.sempoasip.Parent.Home.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.sempoasip.R;

import java.util.List;

/**
 * Created by user on 21/02/2018.
 */

public class AdapterProgressChild extends BaseRecyclerAdapter {

    public AdapterProgressChild(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdapterProgressChild.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {

    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    private class Holder extends RecyclerView.ViewHolder {
        TextView tvBookProgress, tvPageProgress;

        public Holder(View v) {
            super(v);
            tvBookProgress = v.findViewById(R.id.tvBookProgress);
            tvPageProgress = v.findViewById(R.id.tvPageProgress);
        }
    }
}
