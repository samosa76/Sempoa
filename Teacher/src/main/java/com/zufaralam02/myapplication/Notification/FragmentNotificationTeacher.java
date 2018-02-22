package com.zufaralam02.myapplication.Notification;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.myapplication.Notification.Adapter.ANotification;
import com.zufaralam02.myapplication.Notification.Model.ResultNotifTeacher;
import com.zufaralam02.myapplication.R;
import com.zufaralam02.myapplication.Utils.SharedPrefManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNotificationTeacher extends Fragment {


    @BindView(R.id.recyclerNotification)
    RecyclerView recyclerNotification;
    Unbinder unbinder;

    SharedPrefManager sharedPrefManager;
    ANotification adapter;
    String id;

    @BindView(R.id.rlNotif)
    RelativeLayout rlNotif;
    @BindView(R.id.nestedNotif)
    NestedScrollView nestedNotif;

    public FragmentNotificationTeacher() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_notification_teacher, container, false);
        unbinder = ButterKnife.bind(this, view);

        sharedPrefManager = new SharedPrefManager(getActivity());
        HashMap<String, String> users = sharedPrefManager.getUserDetail();
        id = users.get(SharedPrefManager.SP_KODE_GURU);

        ArrayList<ResultNotifTeacher> resultNotif = notifData();
        adapter = new ANotification(getActivity(), resultNotif, R.layout.lv_notif);
        BaseHelper.setupRecyclerView(recyclerNotification, adapter);


        return view;
    }

    private ArrayList<ResultNotifTeacher> notifData() {
        final ArrayList<ResultNotifTeacher> resultNotifTeachers = new ArrayList<>();
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSTeacher/getNotificationByID";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    JSONArray jsonArray = j.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        j = jsonArray.getJSONObject(i);
                        String notifId = j.getString("notification_id");
                        String notifTitle = j.getString("notification_title");
                        String notifTime = j.getString("notification_created");
                        String notifContent = j.getString("notification_content");

                        if (jsonArray.length() == jsonArray.length()) {
                            rlNotif.setVisibility(View.GONE);
                            nestedNotif.setVisibility(View.VISIBLE);
                        }

                        ResultNotifTeacher resultNotification1 = new ResultNotifTeacher();
                        resultNotification1.setNotificationId(notifId);
                        resultNotification1.setNotificationTitle(notifTitle);
                        resultNotification1.setNotificationCreated(notifTime);
                        resultNotification1.setNotificationContent(notifContent);
                        resultNotifTeachers.add(resultNotification1);

                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("kode_guru", id)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();

        return resultNotifTeachers;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.recyclerNotification)
    public void onClick() {
    }


}
