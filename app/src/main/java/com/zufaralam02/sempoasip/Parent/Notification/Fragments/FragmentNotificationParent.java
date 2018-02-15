package com.zufaralam02.sempoasip.Parent.Notification.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Parent.Notification.Adapters.AdapterNotification;
import com.zufaralam02.sempoasip.Parent.Notification.Models.ResultNotification;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    @BindView(R.id.ivNotif)
    ImageView ivNotif;
    @BindView(R.id.tvNotif)
    TextView tvNotif;
    @BindView(R.id.rvIsNull)
    RelativeLayout rvIsNull;

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
//        pass = user.get(SharedPrefManager.SP_PASS);

        ArrayList<ResultNotification> resultNotification = notifData();
        adapterNotification = new AdapterNotification(getActivity(), resultNotification, R.layout.list_notification);
        BaseHelper.setupRecyclerView(recyclerNotification, adapterNotification);

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

                        if (jsonArray.length() == jsonArray.length()) {
                            rvIsNull.setVisibility(View.GONE);
                        }

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
