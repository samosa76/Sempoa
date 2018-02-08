package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RequestCoin extends BaseActivitySempoa {

    @BindView(R.id.btnRequestCoin)
    Button btnDetailRequestCoin;
    @BindView(R.id.request1)
    LinearLayout request1;
    @BindView(R.id.request2)
    LinearLayout request2;
    @BindView(R.id.request3)
    LinearLayout request3;
    @BindView(R.id.request4)
    LinearLayout request4;
    @BindView(R.id.request5)
    LinearLayout request5;
    @BindView(R.id.request6)
    LinearLayout request6;
    @BindView(R.id.request8)
    LinearLayout request8;
    @BindView(R.id.request7)
    LinearLayout request7;
    @BindView(R.id.edtRequestCoin)
    EditText edtRequestCoin;

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_coin);
        ButterKnife.bind(this);

        setupNav("RequestCoin");


    }


    @OnClick({R.id.request1, R.id.request2, R.id.request3, R.id.request4, R.id.request5, R.id.request6, R.id.request8, R.id.request7})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.request1:
                edtRequestCoin.setText("100");
                break;
            case R.id.request2:
                edtRequestCoin.setText("150");
                break;
            case R.id.request3:
                edtRequestCoin.setText("200");
                break;
            case R.id.request4:
                edtRequestCoin.setText("250");
                break;
            case R.id.request5:
                edtRequestCoin.setText("300");
                break;
            case R.id.request6:
                edtRequestCoin.setText("350");
                break;
            case R.id.request7:
                edtRequestCoin.setText("400");
                break;
            case R.id.request8:
                edtRequestCoin.setText("450");
                break;
        }
    }

    @OnClick(R.id.btnRequestCoin)
    public void onClick() {

        data = edtRequestCoin.getText().toString();

        Intent i = new Intent(getApplicationContext(),DetailRequestCoin.class);

        i.putExtra("data",data);

        startActivity(i);

    }
}
