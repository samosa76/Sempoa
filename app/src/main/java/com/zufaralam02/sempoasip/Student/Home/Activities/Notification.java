package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iapps.libs.helpers.BaseHelper;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Notification.Models.Result;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Home.Adapters.AdapterNotificationStudent;
import com.zufaralam02.sempoasip.Student.Home.Model.ModelNotificationStudent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Notification extends BaseActivitySempoa {

    @BindView(R.id.rvNotificationStudent)
    RecyclerView rvNotificationStudent;
    AdapterNotificationStudent adapterNotificationStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        setupNav("Notification");
        ButterKnife.bind(this);

//        ArrayList<ModelNotificationStudent> modelNotificationStudents = notificationDataStudent();
//        AdapterNotificationStudent adapterNotificationStudent = new AdapterNotificationStudent(getApplicationContext(), modelNotificationStudents, R.layout.list_notification);
//        BaseHelper.setupRecyclerView(rvNotificationStudent, adapterNotificationStudent);
//        adapterNotificationStudent.setModelNotificationStudent(modelNotificationStudents);

    }

    private void notificationDaraStudent(ArrayList<Result> results){

        adapterNotificationStudent = new AdapterNotificationStudent(results);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvNotificationStudent.setLayoutManager(layoutManager);
        rvNotificationStudent.setAdapter(adapterNotificationStudent);

    }

//    private ArrayList<ModelNotificationStudent> notificationDataStudent() {
//
//        ArrayList<ModelNotificationStudent> modelNotificationStudents = new ArrayList<>();
//
////        modelNotificationStudents.add(new ModelNotificationStudent(R.string.title_notif1))
//
//    }
}
