package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WithDraw extends BaseActivitySempoa {

    @BindView(R.id.btnWithDrawProses)
    Button btnWithDrawProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_draw);
        ButterKnife.bind(this);

        setupNav("WithDraw");

    }

    @OnClick(R.id.btnWithDrawProses)
    public void onClick() {
        startActivity(new Intent(getApplicationContext(),DetailWithDraw.class));
    }
}
