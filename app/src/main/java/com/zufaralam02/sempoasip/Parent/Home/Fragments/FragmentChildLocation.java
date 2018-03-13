package com.zufaralam02.sempoasip.Parent.Home.Fragments;


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
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentChildLocation extends Fragment {


    @BindView(R.id.tvNameChildLocation)
    TextView tvNameChildLocation;
    @BindView(R.id.tvNumberChildLocation)
    TextView tvNumberChildLocation;
    @BindView(R.id.tvPlaceChildLocation)
    TextView tvPlaceChildLocation;
    @BindView(R.id.ivSettingChildLocation)
    ImageView ivSettingChildLocation;
    @BindView(R.id.frameLocationChild)
    FrameLayout frameLocationChild;
    Unbinder unbinder;

    private int position;
    private String[] child;

    public static FragmentChildLocation newInstance(int position, String[] child) {

        FragmentChildLocation fragmentChildLocation = new FragmentChildLocation();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putStringArray("child", child);
        fragmentChildLocation.setArguments(bundle);
        return fragmentChildLocation;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt("position");
        child = getArguments().getStringArray("child");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_child_location, container, false);
        unbinder = ButterKnife.bind(this, view);

        for (String aChild : child) {
            tvNameChildLocation.append("\n" + aChild.trim());
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.ivSettingChildLocation)
    public void onClick() {
        startActivity(new Intent(getActivity(), ChildSetting.class));
    }
}
