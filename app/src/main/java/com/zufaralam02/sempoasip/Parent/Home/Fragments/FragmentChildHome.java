package com.zufaralam02.sempoasip.Parent.Home.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zufaralam02.sempoasip.Parent.Home.Activities.ChildSetting;
import com.zufaralam02.sempoasip.Parent.Home.Activities.LocationChild;
import com.zufaralam02.sempoasip.Parent.Home.Models.ListMurid;
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentChildHome extends Fragment {
    @BindView(R.id.tvNameChildHome)
    TextView tvNameChildHome;
    @BindView(R.id.tvNumberChildHome)
    TextView tvNumberChildHome;
    @BindView(R.id.tvPlaceChildHome)
    TextView tvPlaceChildHome;
    @BindView(R.id.ivLocationChildHome)
    ImageView ivLocationChildHome;
    @BindView(R.id.ivSettingChildHome)
    ImageView ivSettingChildHome;
    @BindView(R.id.frameHomeChild)
    FrameLayout frameHomeChild;
    Unbinder unbinder;

    private String childName, childNumber, childLocation;
    private int position;

    public static FragmentChildHome newInstance(int position, String childName) {

        FragmentChildHome fragmentChildHome = new FragmentChildHome();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putString("childName", childName);
//        bundle.putString("childNumber", childNumber);
//        bundle.putString("childLocation", childLocation);
        fragmentChildHome.setArguments(bundle);
        return fragmentChildHome;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt("position", 0);
        childName = getArguments().getString("childName");
//        childNumber = getArguments().getString("childNumber");
//        childLocation = getArguments().getString("childLocation");

    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_home, container, false);
        unbinder = ButterKnife.bind(this, view);

//        for (int a = 0; a < childName.length; a++) {
//            tvNameChildHome.append("\n" + childName[a].trim());
////        tvNumberChildHome.setText(childNumber.trim());
////        tvPlaceChildHome.setText(childLocation.trim());
//        }
        for (int i = 0; i < childName.length(); i++) {
            tvNameChildHome.setText(childName.trim());
            tvNumberChildHome.setText(childName.trim());
            tvPlaceChildHome.setText(childName.trim());
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ivLocationChildHome, R.id.ivSettingChildHome})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivLocationChildHome:
                startActivity(new Intent(getActivity(), LocationChild.class));
                break;
            case R.id.ivSettingChildHome:
                startActivity(new Intent(getActivity(), ChildSetting.class));
                break;
        }
    }
}
