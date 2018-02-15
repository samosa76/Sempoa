package com.zufaralam02.sempoasip.Parent.Profil.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zufaralam02.sempoasip.Parent.LoginRegister.Activities.Login;
import com.zufaralam02.sempoasip.Parent.Profil.Activities.AccountSetting;
import com.zufaralam02.sempoasip.Parent.Profil.Activities.Contact;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfilParent extends Fragment {

    @BindView(R.id.cardAccountSetting)
    CardView cardAccountSetting;
    @BindView(R.id.cardContact)
    CardView cardContact;
    @BindView(R.id.cardLogout)
    CardView cardLogout;
    Unbinder unbinder;

    SharedPrefManager sharedPrefManager;

    public FragmentProfilParent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil_parent, container, false);
        unbinder = ButterKnife.bind(this, view);

        sharedPrefManager = new SharedPrefManager(getActivity());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.cardAccountSetting, R.id.cardContact, R.id.cardLogout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardAccountSetting:
                startActivity(new Intent(getActivity(), AccountSetting.class));
                break;
            case R.id.cardContact:
                startActivity(new Intent(getActivity(), Contact.class));
                break;
            case R.id.cardLogout:
                sharedPrefManager.logout();
                startActivity(new Intent(getActivity(), Login.class));
                getActivity().finish();
                break;
        }
    }
}
