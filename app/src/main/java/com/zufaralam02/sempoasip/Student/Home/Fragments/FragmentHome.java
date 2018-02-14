package com.zufaralam02.sempoasip.Student.Home.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Home.Activities.Attandance;
import com.zufaralam02.sempoasip.Student.Notification.Activities.Notification;
import com.zufaralam02.sempoasip.Student.Home.Activities.Wallet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    @BindView(R.id.notificationHomeStudent)
    ImageView notificationHomeStudent;
    @BindView(R.id.ImageProfileStudent)
    ImageView ImageProfileStudent;
    @BindView(R.id.cardAttendance)
    CardView cardAttendance;
    @BindView(R.id.cardStudentWallet)
    CardView cardStudentWallet;
    Unbinder unbinder;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        unbinder = ButterKnife.bind(this, v);
        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.notificationHomeStudent, R.id.ImageProfileStudent, R.id.cardAttendance, R.id.cardStudentWallet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.notificationHomeStudent:
                startActivity(new Intent(getActivity(), Notification.class));
                break;
            case R.id.ImageProfileStudent:
                break;
            case R.id.cardAttendance:
                startActivity(new Intent(getActivity(), Attandance.class));
                break;
            case R.id.cardStudentWallet:
                startActivity(new Intent(getActivity(), Wallet.class));
                break;
        }
    }
}
