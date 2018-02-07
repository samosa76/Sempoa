package com.zufaralam02.myapplication.Profile.Fragment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.myapplication.Home.Model.MHome;
import com.zufaralam02.myapplication.Profile.Fragment.Model.MReward;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/7/2018.
 */

public class AdptReward extends BaseRecyclerAdapter {

    public ArrayList<MReward>getmRewards() {
        return mRewards;
    }

    public AdptReward(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }
    public void setmHome(ArrayList<MReward> mRewards) {
        this.mRewards = mRewards;
    }

    ArrayList<MReward>mRewards = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdptReward.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        AdptReward.Holder holder = (AdptReward.Holder)objectHolder;
        final MReward mReward = (MReward)getItem(position);

        holder.tvDateReward.setText(mReward.getTvDateReward());
        holder.tvNameReward.setText(mReward.getTvNameReward());
        holder.tvValueReward.setText(mReward.getTvDateReward());
    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }
    private class Holder extends RecyclerView.ViewHolder {
        TextView tvNameReward, tvDateReward, tvValueReward;

        public Holder(View v) {
            super(v);

            tvNameReward = v.findViewById(R.id.tvNameReward);
            tvDateReward = v.findViewById(R.id.tvDateReward);
            tvValueReward = v.findViewById(R.id.tvValue);

        }
    }
}
