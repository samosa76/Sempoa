package com.zufaralam02.sempoasip.Parent.Notification.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Notification.Fragments.FragmentNotificationParent;
import com.zufaralam02.sempoasip.Parent.Utils.Helper;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    String title, time, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notification);
        ButterKnife.bind(this);

        setupNav("Notification");
        detailNotif();

    }

    private void detailNotif() {
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/readNotificationByID";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
//                    j = j.getJSONObject("result");
//                    title = j.getString("notification_title");
//                    time = j.getString("notification_created");
//                    content = j.getString("notification_content");
                    JSONArray jsonArray = new JSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.getString("notification_title");
                        String time = jsonObject.getString("notification_created");
                        String content = jsonObject.getString("notification_content");
                        tvTitleDetailNotif.setText(title);
                        tvTimeDetailNotif.setText(time);
                        tvDetailDetailNotif.setText(content);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("parent_id", "1")
                .setPostParams("notif_id", "1")
                .setDisplayError(true)
                .execute();

    }

    @OnClick(R.id.btnDetailNotif)
    public void onClick() {
        startActivity(new Intent(getApplicationContext(), FragmentNotificationParent.class));
    }
}
