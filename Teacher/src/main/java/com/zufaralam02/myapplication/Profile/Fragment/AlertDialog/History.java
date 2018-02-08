package com.zufaralam02.myapplication.Profile.Fragment.AlertDialog;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.iapps.libs.helpers.BaseHelper;
import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.Profile.Fragment.Adapter.AdptReward;
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
        setupNav("History");

        ButterKnife.bind(this);
        ArrayList<MReward>mRewards = rewardshistorydata();
        AdptReward adptReward = new AdptReward(getApplicationContext(),mRewards,R.layout.lv_rewards);
        adptReward.setmHome(mRewards);
        BaseHelper.setupRecyclerView(rvRewarsHistory,adptReward);
    }

    private ArrayList<MReward> rewardshistorydata() {
        ArrayList<MReward>mRewards = new ArrayList<>();
        mRewards.add(new MReward(R.string.profil_reward_value,R.string.profil_reward_form_name,R.string.profil_reward_date));
        mRewards.add(new MReward(R.string.profil_reward_value,R.string.profil_reward_form_name,R.string.profil_reward_date));
        mRewards.add(new MReward(R.string.profil_reward_value,R.string.profil_reward_form_name,R.string.profil_reward_date));
        mRewards.add(new MReward(R.string.profil_reward_value,R.string.profil_reward_form_name,R.string.profil_reward_date));
        mRewards.add(new MReward(R.string.profil_reward_value,R.string.profil_reward_form_name,R.string.profil_reward_date));
        return mRewards;
    }
}
