package com.zufaralam02.myapplication.Profile.Fragment.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.R;

public class ChangeEmail extends BaseActivityTeacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        setupNav("Change Email");
    }
}