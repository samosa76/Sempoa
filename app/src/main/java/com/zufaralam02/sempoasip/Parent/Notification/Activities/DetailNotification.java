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

    String notifId, notifTitle, notifContent, notifTime;

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
                    JSONArray jsonArray = j.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        j = jsonArray.getJSONObject(i);
                        notifId = j.getString("notification_id");
                        notifTitle = j.getString("notification_title");
                        notifContent = j.getString("notification_content");
                        notifTime = j.getString("notification_created");
                    }
                    tvTitleDetailNotif.setText(notifTitle);
                    tvDetailDetailNotif.setText(notifContent);
                    tvTimeDetailNotif.setText(notifTime);
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
