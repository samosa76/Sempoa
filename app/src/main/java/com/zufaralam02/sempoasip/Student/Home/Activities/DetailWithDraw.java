package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailWithDraw extends BaseActivitySempoa {

    @BindView(R.id.textWithDraw)
    TextView textWithDraw;
    @BindView(R.id.btnFinishWithDraw)
    Button btnFinishWithDraw;

    String dataWithDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_with_draw);
        ButterKnife.bind(this);

        dataWithDraw = getIntent().getStringExtra("data");

        textWithDraw.setText("Withdraw RP" + dataWithDraw + " Success!");

        setupNav("DetailRequestCoin");
    }

    @OnClick(R.id.btnFinishWithDraw)
    public void onClick() {

        finish();

    }
}
