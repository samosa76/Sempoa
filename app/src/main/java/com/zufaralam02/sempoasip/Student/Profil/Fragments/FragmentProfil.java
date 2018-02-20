package com.zufaralam02.sempoasip.Student.Profil.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zufaralam02.sempoasip.Parent.LoginRegister.Activities.Login;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Notification.Activities.Notification;
import com.zufaralam02.sempoasip.Student.Profil.Activities.ContactStudent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfil extends Fragment {


    @BindView(R.id.notificationHomeStudent)
    ImageView notificationHomeStudent;
    @BindView(R.id.cvContactStudent)
    CardView cvContactStudent;
    @BindView(R.id.cvLogoutStudent)
    CardView cvLogoutStudent;
    Unbinder unbinder;

    SharedPrefManager sharedPrefManager;

    public FragmentProfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        unbinder = ButterKnife.bind(this, view);

        sharedPrefManager = new SharedPrefManager(getActivity());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.notificationHomeStudent, R.id.cvContactStudent, R.id.cvLogoutStudent})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.notificationHomeStudent:
                startActivity(new Intent(getActivity(), Notification.class));
                break;
            case R.id.cvContactStudent:
                startActivity(new Intent(getActivity(), ContactStudent.class));
                break;
            case R.id.cvLogoutStudent:
                sharedPrefManager.logout();
                break;
        }
    }
}
