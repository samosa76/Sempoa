package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Wallet extends BaseActivitySempoa {

    @BindView(R.id.btnRequestCoin)
    Button btnRequestCoin;
    @BindView(R.id.btnWithDraw)
    Button btnWithDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);

        setupNav("Wallet");

    }

    @OnClick({R.id.btnRequestCoin, R.id.btnWithDraw})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRequestCoin:
                startActivity(new Intent(getApplicationContext(),RequestCoin.class));
                break;
            case R.id.btnWithDraw:
                startActivity(new Intent(getApplicationContext(),WithDraw.class));
                break;
        }
    }
}
