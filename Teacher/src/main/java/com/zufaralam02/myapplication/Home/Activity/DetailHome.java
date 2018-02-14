package com.zufaralam02.myapplication.Home.Activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.iapps.libs.helpers.BaseHelper;
import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.Home.Adapter.AdptDetailHome;
import com.zufaralam02.myapplication.Home.Model.MDetailHeader;
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
    @BindView(R.id.tvNameDetail)
    TextView tvNameDetail;
    @BindView(R.id.tvDateDetail)
    TextView tvDateDetail;

    String setNama,setDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif);
        setupNav("Class");
        ButterKnife.bind(this);

        tvNameDetail.setText(getIntent().getIntExtra("name", 0));
        tvDateDetail.setText(getIntent().getIntExtra("date",0));
        ArrayList<MDetailHeader> mDetailHeaders = notificationData();
        AdptDetailHome adapter = new AdptDetailHome(getApplicationContext(), mDetailHeaders, R.layout.lv_detail_home);
        adapter.setmDetailHeaders(mDetailHeaders);
        BaseHelper.setupRecyclerView(rvDetailHome, adapter);
    }

    private ArrayList<MDetailHeader> notificationData() {

        ArrayList<MDetailHeader> mDetailHeaders = new ArrayList<>();
        mDetailHeaders.add(new MDetailHeader(R.string.home_student_name_1,R.string.home_student_foundation, false));
        mDetailHeaders.add(new MDetailHeader(R.string.home_student_name_2,R.string.home_student_foundation, false));
        mDetailHeaders.add(new MDetailHeader(R.string.home_student_name_3,R.string.home_student_foundation, false));
        mDetailHeaders.add(new MDetailHeader(R.string.home_student_name_4,R.string.home_student_foundation, false));
        mDetailHeaders.add(new MDetailHeader(R.string.home_student_name_5,R.string.home_student_foundation, false));
        return mDetailHeaders;
    }


    @OnClick(R.id.btnAddStudent)
    public void onClick() {
    }
}
