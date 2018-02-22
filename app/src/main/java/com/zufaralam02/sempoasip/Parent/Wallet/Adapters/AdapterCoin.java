package com.zufaralam02.sempoasip.Parent.Wallet.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.sempoasip.Parent.Wallet.Models.ResultCoin;
import com.zufaralam02.sempoasip.R;

import java.util.List;

/**
 * Created by user on 12/02/2018.
 */

public class AdapterCoin extends BaseRecyclerAdapter {
    EditText edtAmountToBuy;

    public EditText getEdtAmountToBuy() {
        return edtAmountToBuy;
    }

    public void setEdtAmountToBuy(EditText edtAmountToBuy) {
        this.edtAmountToBuy = edtAmountToBuy;
    }

    TextView tvPriceTopup;

    public TextView getTvPriceTopup() {
        return tvPriceTopup;
    }

    public void setTvPriceTopup(TextView tvPriceTopup) {
        this.tvPriceTopup = tvPriceTopup;
    }

    public AdapterCoin(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdapterCoin.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        final AdapterCoin.Holder holder = (AdapterCoin.Holder) objectHolder;
        ResultCoin resultCoin = (ResultCoin) getItem(position);
//        ResultCoin resultCoin1 = (ResultCoin) getItem(position * 2 + 1);

        holder.tvJumlahCoin.setText(resultCoin.getSettingJumlahCoin());
        holder.tvKeteranganCoin.setText(resultCoin.getSettingKeterangan());

        holder.linearCoin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtAmountToBuy.setText(holder.tvJumlahCoin.getText().toString());
                tvPriceTopup.setText("Rp " + holder.tvJumlahCoin.getText().toString() + ".000");
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
        TextView tvJumlahCoin, tvKeteranganCoin;
        LinearLayout linearCoin;

        public Holder(View v) {
            super(v);
            tvJumlahCoin = v.findViewById(R.id.tvJumlahCoin);
            tvKeteranganCoin = v.findViewById(R.id.tvKeteranganCoin);
            linearCoin = v.findViewById(R.id.linearCoin);
        }
    }
}
