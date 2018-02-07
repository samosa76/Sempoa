package com.zufaralam02.myapplication.Profile.Fragment.AlertDialog;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.Profile.Fragment.Model.MReward;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class History extends BaseActivityTeacher {

    @BindView(R.id.rvRewarsHistory)
    RecyclerView rvRewarsHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ArrayList<MReward>mRewards = rewardshistorydata();

        ButterKnife.bind(this);
    }

    private ArrayList<MReward> rewardshistorydata() {
        return null;
    }
}
