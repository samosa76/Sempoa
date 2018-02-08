package com.zufaralam02.sempoasip.Parent.Profil.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
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

    String id, name, email, hp, pass;
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

        id = getActivity().getIntent().getStringExtra("parent_id");
        name = getActivity().getIntent().getStringExtra("parent_fullname");
        email = getActivity().getIntent().getStringExtra("parent_email");
        hp = getActivity().getIntent().getStringExtra("parent_hp_nr");
        pass = getActivity().getIntent().getStringExtra("parent_pwd");

        sharedPrefManager = new SharedPrefManager(getActivity());
//        if (sharedPrefManager.getSPIsLogin()) {
//            startActivity(new Intent(getActivity(), Login.class)
//                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
//            getActivity().finish();
//        }

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
                Intent intent = new Intent(getActivity(), AccountSetting.class);
                intent.putExtra("parent_id", id);
                intent.putExtra("parent_fullname", name);
                intent.putExtra("parent_email", email);
                intent.putExtra("parent_hp_nr", hp);
                intent.putExtra("parent_pwd", pass);
                startActivity(intent);
                break;
            case R.id.cardContact:
                Intent intent1 = new Intent(getActivity(), Contact.class);
                intent1.putExtra("parent_id", id);
                intent1.putExtra("parent_fullname", name);
                intent1.putExtra("parent_email", email);
                intent1.putExtra("parent_hp_nr", hp);
                intent1.putExtra("parent_pwd", pass);
                startActivity(intent1);
                break;
            case R.id.cardLogout:
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_IS_LOGIN, false);
                startActivity(new Intent(getActivity(), Login.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                getActivity().finish();
                startActivity(new Intent(getActivity(), Login.class));
                break;
        }
    }
}
