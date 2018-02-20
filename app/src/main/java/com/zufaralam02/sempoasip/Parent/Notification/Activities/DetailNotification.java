package com.zufaralam02.sempoasip.Parent.Notification.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailNotification extends BaseActivitySempoa {

    @BindView(R.id.ivDetailNotif)
    ImageView ivDetailNotif;
    @BindView(R.id.tvTitleDetailNotif)
    TextView tvTitleDetailNotif;
    @BindView(R.id.tvTimeDetailNotif)
    TextView tvTimeDetailNotif;
    @BindView(R.id.tvDetailDetailNotif)
    TextView tvDetailDetailNotif;
    @BindView(R.id.btnDetailNotif)
    Button btnDetailNotif;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;
    String idNotif, titleNotif, timeNotif, contentNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notification);
        ButterKnife.bind(this);

        setupNav("Notification");
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

        idNotif = getIntent().getStringExtra("notifId");
        titleNotif = getIntent().getStringExtra("notifTitle");
        timeNotif = getIntent().getStringExtra("notifTime");
        contentNotif = getIntent().getStringExtra("notifContent");

        tvTitleDetailNotif.setText(titleNotif);
        tvTimeDetailNotif.setText(timeNotif);
        tvDetailDetailNotif.setText(contentNotif);

//        detailNotif();

    }

//    private void detailNotif() {
//        HTTPImb httpImb = new HTTPImb(this, true) {
//            @Override
//            public String url() {
//                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/readNotificationByID";
//            }
//
//            @Override
//            public void onSuccess(JSONObject j) {
//                try {
//                    JSONArray jsonArray = j.getJSONArray("result");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        j = jsonArray.getJSONObject(i);
//                        String notifId = j.getString("notification_id");
//                        String notifTitle = j.getString("notification_title");
//                        String notifContent = j.getString("notification_content");
//                        String notifTime = j.getString("notification_created");
//                        tvTitleDetailNotif.setText(notifTitle);
//                        tvDetailDetailNotif.setText(notifContent);
//                        tvTimeDetailNotif.setText(notifTime);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        httpImb.setPostParams("parent_id", id)
//                .setPostParams("notif_id", idNotif)
//                .setDisplayError(true)
//                .setDisplayProgress(false)
//                .execute();
//
//    }

    @OnClick(R.id.btnDetailNotif)
    public void onClick() {
        finish();
    }
}
