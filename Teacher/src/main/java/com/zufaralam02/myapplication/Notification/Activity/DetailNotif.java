package com.zufaralam02.myapplication.Notification.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailNotif extends BaseActivityTeacher {

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
        setContentView(R.layout.activity_detail_notif_teacher);
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
