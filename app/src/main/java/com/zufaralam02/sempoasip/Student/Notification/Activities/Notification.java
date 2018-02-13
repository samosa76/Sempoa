package com.zufaralam02.sempoasip.Student.Notification.Activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.iapps.libs.helpers.BaseHelper;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Notification.Adapters.AdapterNotificationStudent;
import com.zufaralam02.sempoasip.Student.Notification.Model.ModelNotificationStudent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Notification extends BaseActivitySempoa {

    @BindView(R.id.rvNotificationStudent)
    RecyclerView rvNotificationStudent;
    private AdapterNotificationStudent adapterNotificationStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        setupNav("Notification");
        ButterKnife.bind(this);

        ArrayList<ModelNotificationStudent> modelNotificationStudents = notificationDataStudent();
        AdapterNotificationStudent adapterNotificationStudent = new AdapterNotificationStudent(getApplicationContext(), modelNotificationStudents,R.layout.list_notification_student);
        BaseHelper.setupRecyclerView(rvNotificationStudent, adapterNotificationStudent);
        adapterNotificationStudent.setModelNotificationStudents(modelNotificationStudents);

    }

    private ArrayList<ModelNotificationStudent> notificationDataStudent() {

        ArrayList<ModelNotificationStudent> modelNotificationStudent = new ArrayList<>();

        modelNotificationStudent.add(new ModelNotificationStudent(R.string.title_notif1, R.string.detail_notif1, R.string.time_notif1,
                R.drawable.ic_notif, true));
        modelNotificationStudent.add(new ModelNotificationStudent(R.string.title_notif2, R.string.detail_notif2, R.string.time_notif2,
                R.drawable.ic_comment, true));
        modelNotificationStudent.add(new ModelNotificationStudent(R.string.title_notif3, R.string.detail_notif3, R.string.time_notif3,
                R.drawable.ic_wallet, false));
        modelNotificationStudent.add(new ModelNotificationStudent(R.string.title_notif4, R.string.detail_notif4, R.string.time_notif4,
                R.drawable.ic_announcement, false));
        modelNotificationStudent.add(new ModelNotificationStudent(R.string.title_notif5, R.string.detail_notif5, R.string.time_notif5,
                R.drawable.ic_call, false));

        return modelNotificationStudent;

    }
}
