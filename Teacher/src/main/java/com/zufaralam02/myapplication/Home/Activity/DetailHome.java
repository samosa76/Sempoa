package com.zufaralam02.myapplication.Home.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.R;

public class DetailHome extends BaseActivityTeacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif);
        setupNav("Class");
    }
}
