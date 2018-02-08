package com.zufaralam02.sempoasip.Parent.Profil.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.sempoasip.Parent.Profil.Models.ModelContact;
import com.zufaralam02.sempoasip.Parent.Profil.Models.ResultContact;
import com.zufaralam02.sempoasip.R;

import java.util.List;

/**
 * Created by user on 07/02/2018.
 */

public class AdapterContact extends BaseRecyclerAdapter {

    public AdapterContact(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdapterContact.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        AdapterContact.Holder holder = (AdapterContact.Holder) objectHolder;
        ResultContact resultContact = (ResultContact) getItem(position);

        holder.tvContact.setText(resultContact.getNama());
        holder.tvNumberContact.setText(resultContact.getNomorTelp());
    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    private class Holder extends RecyclerView.ViewHolder {
        TextView tvContact, tvNumberContact;

        public Holder(View v) {
            super(v);
            tvContact = v.findViewById(R.id.tvContact);
            tvNumberContact = v.findViewById(R.id.tvNumberContact);
        }
    }
}
