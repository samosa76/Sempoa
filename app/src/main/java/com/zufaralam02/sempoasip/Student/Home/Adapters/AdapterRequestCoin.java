package com.zufaralam02.sempoasip.Student.Home.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Home.Model.ResultRequestCoin;

import java.util.List;

/**
 * Created by Asus on 2/14/2018.
 */

public class AdapterRequestCoin extends BaseRecyclerAdapter {
    private EditText edtCoin;

    public AdapterRequestCoin(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdapterRequestCoin.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {

        final AdapterRequestCoin.Holder holder = (AdapterRequestCoin.Holder) objectHolder;
        ResultRequestCoin resultRequestCoin = (ResultRequestCoin) getItem(position);

        holder.tvRequestCoinStudent.setText(resultRequestCoin.getSettingJumlahCoin());
        holder.tvRequestKeteranganStudent.setText(resultRequestCoin.getSettingKeterangan());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCoin.setText(holder.tvRequestCoinStudent.getText().toString());
            }
        });

    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    public void setEdtCoin(EditText edtCoin) {
        this.edtCoin = edtCoin;
    }

    public class Holder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView tvRequestCoinStudent,tvRequestKeteranganStudent;

        public Holder(View v) {
            super(v);

            linearLayout = v.findViewById(R.id.linearCoinStudent);
            tvRequestCoinStudent = v.findViewById(R.id.tvCoinStudent);
            tvRequestKeteranganStudent = v.findViewById(R.id.tvKeteranganStudent);

        }
    }
}
