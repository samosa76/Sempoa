package com.zufaralam02.sempoasip.Student.Notification.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;

public class DetailNotificationStudent extends BaseActivitySempoa {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notification_student);

        setupNav("Notification");

    }
}
