package com.zufaralam02.sempoasip.Parent.Notification.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.iapps.libs.helpers.BaseApi;
import com.iapps.libs.helpers.BaseHelper;
import com.zufaralam02.sempoasip.ApiHelper.BaseApiService;
import com.zufaralam02.sempoasip.ApiHelper.RetrofitClient;
import com.zufaralam02.sempoasip.Parent.Notification.Adapters.AdapterNotification;
import com.zufaralam02.sempoasip.Parent.Notification.Models.ModelNotification;
import com.zufaralam02.sempoasip.Parent.Notification.Models.ModelNotificationn;
import com.zufaralam02.sempoasip.Parent.Notification.Models.Result;
import com.zufaralam02.sempoasip.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNotificationParent extends Fragment {
    @BindView(R.id.recyclerNotification)
    RecyclerView recyclerNotification;
    Unbinder unbinder;
    private AdapterNotification adapterNotification;

    public FragmentNotificationParent() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_parent, container, false);
        unbinder = ButterKnife.bind(this, view);

        BaseApiService baseApiService = RetrofitClient.getClient().create(BaseApiService.class);

        Call<ModelNotificationn> call = baseApiService.getNotification("1");
        call.enqueue(new Callback<ModelNotificationn>() {
            @Override
            public void onResponse(Call<ModelNotificationn> call, Response<ModelNotificationn> response) {
                if (response.isSuccessful()) {
                    notificationData((ArrayList<Result>) response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<ModelNotificationn> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
//        ArrayList<ModelNotification> modelNotification = notificationData();
//        AdapterNotification adapterNotification = new AdapterNotification(getActivity(), modelNotification, R.layout.list_notification);
//        BaseHelper.setupRecyclerView(recyclerNotification, adapterNotification);
//        adapterNotification.setModelNotification(modelNotification);

        return view;
    }

    private void notificationData(ArrayList<Result> result) {

        adapterNotification = new AdapterNotification(result);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerNotification.setLayoutManager(layoutManager);
        recyclerNotification.setAdapter(adapterNotification);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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

}
