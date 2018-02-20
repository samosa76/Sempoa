package com.zufaralam02.myapplication.Profile.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zufaralam02.myapplication.Profile.Fragment.Activity.Contac;
import com.zufaralam02.myapplication.Profile.Fragment.Activity.DetailProfil;
import com.zufaralam02.myapplication.Profile.Fragment.Activity.Rewards;
import com.zufaralam02.myapplication.Profile.Fragment.AlertDialog.History;
import com.zufaralam02.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfilTeacher extends Fragment {


    @BindView(R.id.llReward)
    LinearLayout llReward;
    @BindView(R.id.llAccountSetting)
    LinearLayout llAccountSetting;
    @BindView(R.id.llContac)
    LinearLayout llContac;
    @BindView(R.id.llLogut)
    LinearLayout llLogut;
    @BindView(R.id.imgSetting)
    ImageView imgSetting;
    Unbinder unbinder;

    public FragmentProfilTeacher() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.llReward, R.id.llAccountSetting, R.id.llContac, R.id.llLogut, R.id.imgSetting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llReward:
                startActivity(new Intent(getActivity(), Rewards.class));
                break;
            case R.id.llAccountSetting:
                startActivity(new Intent(getActivity(), DetailProfil.class));
                break;
            case R.id.llContac:
                startActivity(new Intent(getActivity(), Contac.class));
                break;
            case R.id.llLogut:
                break;
            case R.id.imgSetting:
                custumalerdialog();
                break;
        }
    }

    private void custumalerdialog() {
        final BottomSheetDialog builder = new BottomSheetDialog(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.cutom_dialog_rewards, null);
        builder.setContentView(view);
        builder.setCancelable(false);
        view.findViewById(R.id.cardHistory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), History.class));
                builder.cancel();
            }
        });
        view.findViewById(R.id.cardWithdraw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Rewards.class));
                builder.cancel();
            }
        });
        view.findViewById(R.id.cardCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.cancel();
            }
        });
//        ((TextView) view.findViewById(R.id.tvTimerResult)).setText(tvCountDownTimer.getText().toString());
        builder.show();
    }
}