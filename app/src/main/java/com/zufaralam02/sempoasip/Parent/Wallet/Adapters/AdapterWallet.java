package com.zufaralam02.sempoasip.Parent.Wallet.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.sempoasip.Parent.Wallet.Activities.TopupCoin;
import com.zufaralam02.sempoasip.Parent.Wallet.Models.ListMurid;
import com.zufaralam02.sempoasip.R;

import java.util.List;

/**
 * Created by user on 19/01/2018.
 */

public class AdapterWallet extends BaseRecyclerAdapter {

    public AdapterWallet(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdapterWallet.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        AdapterWallet.Holder holder = (AdapterWallet.Holder) objectHolder;
        final ListMurid listMurid = (ListMurid) getItem(position);

        holder.tvWalletName.setText(listMurid.getNamaSiswa());
        holder.tvWalletCoin.setText(listMurid.getWallet());

        holder.btnWalletTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TopupCoin.class);
                intent.putExtra("namaSiswa", listMurid.getNamaSiswa());
                intent.putExtra("kodeSiswa", listMurid.getKodeSiswa());
                getContext().startActivity(intent);
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
        TextView tvWalletName, tvWalletCoin;
        Button btnWalletTopup, btnWalletPending;

        public Holder(View v) {
            super(v);
            tvWalletName = v.findViewById(R.id.tvWalletName);
            tvWalletCoin = v.findViewById(R.id.tvWalletCoin);
            btnWalletTopup = v.findViewById(R.id.btnWalletTopup);
            btnWalletPending = v.findViewById(R.id.btnWalletPending);
        }
    }

}
