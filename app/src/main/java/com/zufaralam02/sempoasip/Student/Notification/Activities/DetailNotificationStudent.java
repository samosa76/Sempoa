package com.zufaralam02.sempoasip.Student.Notification.Activities;

import android.os.Bundle;
import android.widget.TextView;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailNotificationStudent extends BaseActivitySempoa {

    SharedPrefManager sharedPrefManager;
    @BindView(R.id.tvTitleDetailNotif)
    TextView tvTitleDetailNotif;
    @BindView(R.id.tvTimeDetailNotif)
    TextView tvTimeDetailNotif;
    @BindView(R.id.tvDetailDetailNotif)
    TextView tvDetailDetailNotif;

    String time,content,title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notification_student);
        ButterKnife.bind(this);

        time = getIntent().getStringExtra("time");
        content = getIntent().getStringExtra("detail");
        title = getIntent().getStringExtra("title");

        tvDetailDetailNotif.setText(content);
        tvTimeDetailNotif.setText(time);
        tvTitleDetailNotif.setText(title);

        setupNav("Notification");

    }
}
