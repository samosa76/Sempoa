package com.zufaralam02.sempoasip.Student.Home.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Home.Model.ModelHistoryReward;

import java.util.List;

/**
 * Created by Asus on 2/12/2018.
 */

public class AdapterHistoryReward extends BaseRecyclerAdapter {
    public AdapterHistoryReward(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdapterHistoryReward.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {

        AdapterHistoryReward.Holder holder = (AdapterHistoryReward.Holder) objectHolder;
        ModelHistoryReward modelHistory = (ModelHistoryReward) getItem(position);

        holder.tvNameWalletHistoryStudent.setText(modelHistory.getHistoryNameReward());
        holder.tvTimeWalletHistoryStudent.setText(modelHistory.getHistoryTimeReward());
        holder.tvCoinWalletHistoryStudent.setText(modelHistory.getHistoryCoinReward());

        if (modelHistory.isPending()) {
            holder.tvPendingWalletHistoryStudent.setVisibility(View.VISIBLE);
        } else {
            holder.tvPendingWalletHistoryStudent.setVisibility(View.GONE);
        }

    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tvNameWalletHistoryStudent, tvTimeWalletHistoryStudent, tvCoinWalletHistoryStudent, tvPendingWalletHistoryStudent;
        public Holder(View v) {
            super(v);

            tvNameWalletHistoryStudent = v.findViewById(R.id.tvNameWalletHistoryStudent);
            tvTimeWalletHistoryStudent = v.findViewById(R.id.tvTimeWalletHistoryStudent);
            tvCoinWalletHistoryStudent = v.findViewById(R.id.tvCoinWalletHistoryStudent);
            tvPendingWalletHistoryStudent = v.findViewById(R.id.tvPendingWalletHistoryStudent);

        }
    }
}
