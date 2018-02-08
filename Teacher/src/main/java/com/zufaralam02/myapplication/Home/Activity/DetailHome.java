package com.zufaralam02.myapplication.Home.Activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.iapps.libs.helpers.BaseHelper;
import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.Home.Adapter.AHome;
import com.zufaralam02.myapplication.Home.Adapter.AdptDetailHome;
import com.zufaralam02.myapplication.Home.Model.MDetailHome;
import com.zufaralam02.myapplication.Home.Model.MHome;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif);
        setupNav("Class");
        ButterKnife.bind(this);

        tvNameDetail.setText(getIntent().getStringExtra("name"));
        tvDateDetail.setText(getIntent().getStringExtra("date"));

        ArrayList<MDetailHome>mDetailHomes= notificationData();
        AdptDetailHome adapter = new AdptDetailHome(getApplicationContext(), mDetailHomes, R.layout.lv_detail_home);
        adapter.setmDetailHomes(mDetailHomes);
        BaseHelper.setupRecyclerView(rvDetailHome, adapter);
    }

    private ArrayList<MDetailHome> notificationData() {

        ArrayList<MDetailHome>mDetailHomes = new ArrayList<>();
        mDetailHomes.add(new MDetailHome(R.string.home_student_name_1,R.string.home_student_foundation));
        mDetailHomes.add(new MDetailHome(R.string.home_student_name_2,R.string.home_student_foundation));
        mDetailHomes.add(new MDetailHome(R.string.home_student_name_3,R.string.home_student_foundation));
        mDetailHomes.add(new MDetailHome(R.string.home_student_name_4,R.string.home_student_foundation));
        mDetailHomes.add(new MDetailHome(R.string.home_student_name_5,R.string.home_student_foundation));
        return mDetailHomes;
    }


    @OnClick(R.id.btnAddStudent)
    public void onClick() {
    }
}
