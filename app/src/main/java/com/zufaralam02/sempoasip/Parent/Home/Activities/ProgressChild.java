package com.zufaralam02.sempoasip.Parent.Home.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressChild extends BaseActivitySempoa {

    @BindView(R.id.tvBookProgress)
    TextView tvBookProgress;
    @BindView(R.id.tvPageProgress)
    TextView tvPageProgress;
    @BindView(R.id.tvTimeProgress)
    TextView tvTimeProgress;
    @BindView(R.id.cardFeedback)
    CardView cardFeedback;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_child);
        ButterKnife.bind(this);

        setupNav("Progress");

        sharedPrefManager = new SharedPrefManager(this);
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

        requstProgress();
    }

    private void requstProgress() {
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://";
            }

            @Override
            public void onSuccess(JSONObject j) {

            }
        };
        httpImb.setPostParams("parent_id", id)
                .setDisplayError(true)
                .execute();
    }

    @OnClick(R.id.cardFeedback)
    public void onClick() {
        startActivity(new Intent(getApplicationContext(), FeedbackChild.class));
    }
}
