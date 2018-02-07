package com.zufaralam02.myapplication.Profile.Fragment.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailProfil extends BaseActivityTeacher {

    @BindView(R.id.tvBack)
    TextView tvBack;
    @BindView(R.id.llBack)
    LinearLayout llBack;
    @BindView(R.id.tvChangename)
    TextView tvChangename;
    @BindView(R.id.tvChangeEmail)
    TextView tvChangeEmail;
    @BindView(R.id.tvChangePhone)
    TextView tvChangePhone;
    @BindView(R.id.tvChangePass)
    TextView tvChangePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profil);
        ButterKnife.bind(this);
        setupNav("Account Setting");

    }

    @OnClick({R.id.tvChangename, R.id.tvChangeEmail, R.id.tvChangePhone, R.id.tvChangePass})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvChangename:
                startActivity(new Intent(this,ChangeName.class));
                break;
            case R.id.tvChangeEmail:
                startActivity(new Intent(this,ChangeEmail.class));
                break;
            case R.id.tvChangePhone:
                startActivity(new Intent(this,ChangePhonenumber.class));
                break;
            case R.id.tvChangePass:
                startActivity(new Intent(this,ChangePassword.class));
                break;
        }
    }
}
