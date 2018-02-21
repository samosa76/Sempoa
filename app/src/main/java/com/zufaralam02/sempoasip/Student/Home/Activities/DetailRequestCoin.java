package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.os.Bundle;
import android.widget.TextView;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailRequestCoin extends BaseActivitySempoa {

    @BindView(R.id.textcoin)
    TextView textcoin;

    String dataCoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_request_coin);
        ButterKnife.bind(this);

        dataCoin = getIntent().getStringExtra("coin");

        textcoin.setText("Request "+dataCoin+ " Coin Success!");

        setupNav("DetailRequestCoin");

    }
}
