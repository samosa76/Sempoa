package com.zufaralam02.sempoasip.Parent.Wallet.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.sempoasip.Parent.Wallet.Models.ResultHistory;
import com.zufaralam02.sempoasip.R;

import java.util.List;

/**
 * Created by user on 19/01/2018.
 */

public class AdapterHistory extends BaseRecyclerAdapter {

    public AdapterHistory(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdapterHistory.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        AdapterHistory.Holder holder = (AdapterHistory.Holder) objectHolder;
        ResultHistory resultHistory = (ResultHistory) getItem(position);

        holder.tvNameWalletHistory.setText(resultHistory.getNamaSiswa());
        holder.tvTimeWalletHistory.setText(resultHistory.getTopupCreatedDate());
        holder.tvCoinWalletHistory.setText("+ " + resultHistory.getTopupJumlah() + " Coin");

    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    private class Holder extends RecyclerView.ViewHolder {
        TextView tvNameWalletHistory, tvTypeWalletHistory, tvTimeWalletHistory, tvCoinWalletHistory;

        public Holder(View v) {
            super(v);
            tvNameWalletHistory = v.findViewById(R.id.tvNameWalletHistory);
            tvTypeWalletHistory = v.findViewById(R.id.tvTypeWalletHistory);
            tvTimeWalletHistory = v.findViewById(R.id.tvTimeWalletHistory);
            tvCoinWalletHistory = v.findViewById(R.id.tvCoinWalletHistory);
        }
    }
}
