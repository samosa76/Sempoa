package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;

public class RequestCoin extends BaseActivitySempoa {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_coin);

        setupNav("RequestCoin");

    }
}
