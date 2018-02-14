package com.zufaralam02.myapplication.Home;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.iapps.libs.helpers.BaseHelper;
import com.zufaralam02.myapplication.Home.Adapter.AHome;
import com.zufaralam02.myapplication.Home.Model.MHome;
import com.zufaralam02.myapplication.Profile.Fragment.FragmentProfilTeacher;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHomeTeacher extends Fragment {


    @BindView(R.id.rvHome)
    RecyclerView rvHome;
    Unbinder unbinder;
    @BindView(R.id.llhomep)
    LinearLayout llhomep;

    public FragmentHomeTeacher() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home_teacher, container, false);
        unbinder = ButterKnife.bind(this, view);


        ArrayList<MHome> mHome = notificationData();
        AHome adapter = new AHome(getActivity(), mHome, R.layout.lv_home);
        adapter.setmHome(mHome);
        BaseHelper.setupRecyclerView(rvHome, adapter);


        return view;
    }

    private ArrayList<MHome> notificationData() {
        ArrayList<MHome> modelNotification = new ArrayList<>();

        modelNotification.add(new MHome(R.string.lv_name_1, R.string.lv_date_1));
        modelNotification.add(new MHome(R.string.lv_name_2, R.string.lv_date_2));
        modelNotification.add(new MHome(R.string.lv_name_3, R.string.lv_date_3));

        return modelNotification;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    BottomNavigationView navigation;

    public BottomNavigationView getNavigation() {
        return navigation;
    }

    public void setNavigation(BottomNavigationView navigation) {
        this.navigation = navigation;
    }

    @OnClick({R.id.llhomep})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llhomep:
                FragmentProfilTeacher fmProf = new FragmentProfilTeacher();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_teacher, fmProf).commit();
                break;
        }
    }
}
