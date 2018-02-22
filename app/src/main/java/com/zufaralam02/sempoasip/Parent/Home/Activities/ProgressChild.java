package com.zufaralam02.sempoasip.Parent.Home.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressChild extends BaseActivitySempoa {

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;
    @BindView(R.id.recyclerProgress)
    RecyclerView recyclerProgress;
    @BindView(R.id.tvTimeProgress)
    TextView tvTimeProgress;
    @BindView(R.id.ivArrow1)
    ImageView ivArrow1;
    @BindView(R.id.cardFeedback)
    CardView cardFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_child);
        ButterKnife.bind(this);

        setupNav("Progress");

        sharedPrefManager = new SharedPrefManager(this);
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

    }

    @OnClick(R.id.cardFeedback)
    public void onClick() {
        startActivity(new Intent(getApplicationContext(), FeedbackChild.class));
    }
}

