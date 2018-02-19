package com.zufaralam02.myapplication.Notification;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iapps.libs.helpers.BaseHelper;
import com.zufaralam02.myapplication.Notification.Adapter.ANotification;
import com.zufaralam02.myapplication.Notification.Model.MNotif;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;

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

    public FragmentNotificationTeacher() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_notification_teacher, container, false);
        unbinder = ButterKnife.bind(this, view);

        ArrayList<MNotif> mNotif = notificationData();
        ANotification adapter = new ANotification(getActivity(), mNotif, R.layout.lv_notif);
        BaseHelper.setupRecyclerView(recyclerNotification, adapter);
        adapter.setModelNotification(mNotif);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.recyclerNotification)
    public void onClick() {
    }

    private ArrayList<MNotif> notificationData() {
        ArrayList<MNotif> modelNotification = new ArrayList<>();

        modelNotification.add(new MNotif(R.string.title_notif1, R.string.detail_notif1, R.string.time_notif1,
                R.drawable.ic_notif, true));
        modelNotification.add(new MNotif(R.string.title_notif2, R.string.detail_notif2, R.string.time_notif2,
                R.drawable.ic_comment, true));
        modelNotification.add(new MNotif(R.string.title_notif3, R.string.detail_notif3, R.string.time_notif3,
                R.drawable.ic_wallet, false));
        modelNotification.add(new MNotif(R.string.title_notif4, R.string.detail_notif4, R.string.time_notif4,
                R.drawable.ic_announcement, false));
        modelNotification.add(new MNotif(R.string.title_notif5, R.string.detail_notif5, R.string.time_notif5,
                R.drawable.ic_call, false));
        return modelNotification;
    }
}
