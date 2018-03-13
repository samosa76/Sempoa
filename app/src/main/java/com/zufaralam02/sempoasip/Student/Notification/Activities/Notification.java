package com.zufaralam02.sempoasip.Student.Notification.Activities;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Notification.Adapters.AdapterNotificationStudent;
import com.zufaralam02.sempoasip.Student.Notification.Model.ResultNotificationStudent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Notification extends BaseActivitySempoa {

    @BindView(R.id.rvNotificationStudent)
    RecyclerView rvNotificationStudent;
    @BindView(R.id.rvIsNull)
    RelativeLayout rvIsNull;
    @BindView(R.id.nestedNotif)
    NestedScrollView nestedNotif;
    private AdapterNotificationStudent adapterNotificationStudent;

    SharedPrefManager sharedPrefManager;

    String kodeSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> key = sharedPrefManager.getUserDetail();

        kodeSiswa = key.get(sharedPrefManager.SP_KODE_SISWA);

        setupNav("Notification");
        ButterKnife.bind(this);

        ArrayList<ResultNotificationStudent> modelNotificationStudents = notificationDataStudent();
        adapterNotificationStudent = new AdapterNotificationStudent(getApplicationContext(), modelNotificationStudents, R.layout.list_notification_student);
        BaseHelper.setupRecyclerView(rvNotificationStudent, adapterNotificationStudent);

    }

    private ArrayList<ResultNotificationStudent> notificationDataStudent() {
        final ArrayList<ResultNotificationStudent> modelNotificationStudent = new ArrayList<>();
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSChild/getNotificationByID";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    JSONArray jsonArray = j.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        j = jsonArray.getJSONObject(i);

                        String notifId = j.getString("notification_id");
                        String notifTitle = j.getString("notification_title");
                        String notifContent = j.getString("notification_content");
                        String notiTime = j.getString("notification_created");

                        if (jsonArray.length() == jsonArray.length()) {
                            rvIsNull.setVisibility(View.GONE);
                            nestedNotif.setVisibility(View.VISIBLE);
                        }

                        ResultNotificationStudent resultNotificationStudent = new ResultNotificationStudent();

                        resultNotificationStudent.setNotificationId(notifId);
                        resultNotificationStudent.setNotificationTitle(notifTitle);
                        resultNotificationStudent.setNotificationContent(notifContent);
                        resultNotificationStudent.setNotificationCreated(notiTime);
                        modelNotificationStudent.add(resultNotificationStudent);
                    }
                    adapterNotificationStudent.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        httpImb.setPostParams("kode_siswa", kodeSiswa)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();

        return modelNotificationStudent;
    }
}
