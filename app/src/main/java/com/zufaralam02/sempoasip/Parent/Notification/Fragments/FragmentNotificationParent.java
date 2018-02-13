package com.zufaralam02.sempoasip.Parent.Notification.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Parent.Notification.Activities.DetailNotification;
import com.zufaralam02.sempoasip.Parent.Notification.Adapters.AdapterNotification;
import com.zufaralam02.sempoasip.Parent.Notification.Models.ResultNotification;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNotificationParent extends Fragment {
    @BindView(R.id.recyclerNotification)
    RecyclerView recyclerNotification;
    Unbinder unbinder;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;
    AdapterNotification adapterNotification;

    public FragmentNotificationParent() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_parent, container, false);
        unbinder = ButterKnife.bind(this, view);

        sharedPrefManager = new SharedPrefManager(getActivity());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
        pass = user.get(SharedPrefManager.SP_PASS);

        ArrayList<ResultNotification> resultNotification = notifData();
        adapterNotification = new AdapterNotification(getActivity(), resultNotification, R.layout.list_notification);
        BaseHelper.setupRecyclerView(recyclerNotification, adapterNotification);

//        ArrayList<ModelNotification> modelNotification = notificationData();
//        AdapterNotification adapterNotification = new AdapterNotification(getActivity(), modelNotification, R.layout.list_notification);
//        BaseHelper.setupRecyclerView(recyclerNotification, adapterNotification);
//        adapterNotification.setModelNotification(modelNotification);
        return view;
    }

    private ArrayList<ResultNotification> notifData() {
        final ArrayList<ResultNotification> resultNotification = new ArrayList<>();
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/getNotificationByID";
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

                        ResultNotification resultNotification1 = new ResultNotification();
                        resultNotification1.setNotificationId(notifId);
                        resultNotification1.setNotificationTitle(notifTitle);
                        resultNotification1.setNotificationCreated(notifTime);
                        resultNotification1.setNotificationContent(notifContent);
                        resultNotification.add(resultNotification1);
                    }
                    adapterNotification.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();

        return resultNotification;
    }

    //    private ArrayList<ModelNotification> notificationData() {
//
//        ArrayList<ModelNotification> modelNotification = new ArrayList<>();
//
//        modelNotification.add(new ModelNotification(R.string.title_notif1, R.string.detail_notif1, R.string.time_notif1,
//                R.drawable.ic_notif, true));
//        modelNotification.add(new ModelNotification(R.string.title_notif2, R.string.detail_notif2, R.string.time_notif2,
//                R.drawable.ic_comment, true));
//        modelNotification.add(new ModelNotification(R.string.title_notif3, R.string.detail_notif3, R.string.time_notif3,
//                R.drawable.ic_wallet, false));
//        modelNotification.add(new ModelNotification(R.string.title_notif4, R.string.detail_notif4, R.string.time_notif4,
//                R.drawable.ic_announcement, false));
//        modelNotification.add(new ModelNotification(R.string.title_notif5, R.string.detail_notif5, R.string.time_notif5,
//                R.drawable.ic_call, false));
//
////        for (int i = 0; i < titleNotif.length; i++) {
////
////            ModelNotification modelNotification1 = new ModelNotification();
////            modelNotification1.setTitleNotif(titleNotif[i]);
////            modelNotification1.setDetailNotif(detailNotif[i]);
////            modelNotification1.setTimeNotif(timeNotif[i]);
////            modelNotification1.setImageNotif(imageNotif[i]);
////            modelNotification.add(modelNotification1);
////        }
//
//        return modelNotification;
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
