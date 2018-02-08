package com.zufaralam02.myapplication.Home.Activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.iapps.libs.helpers.BaseHelper;
import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailHome extends BaseActivityTeacher {

    @BindView(R.id.btnAddStudent)
    Button btnAddStudent;
    @BindView(R.id.rvDetailHome)
    RecyclerView rvDetailHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif);
        setupNav("Class");
        ButterKnife.bind(this);



    }
    @OnClick(R.id.btnAddStudent)
    public void onClick() {
    }
}
