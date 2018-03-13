package com.zufaralam02.myapplication.Profile.Fragment.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.R;
import com.zufaralam02.myapplication.Utils.SharedPrefManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailProfil extends BaseActivityTeacher {

    @BindView(R.id.tvBack)
    TextView tvBack;
    @BindView(R.id.llBack)
    LinearLayout llBack;
    @BindView(R.id.tvChangename)
    TextView tvChangename;
    @BindView(R.id.tvChangeEmail)
    TextView tvChangeEmail;
    @BindView(R.id.tvChangePhone)
    TextView tvChangePhone;
    @BindView(R.id.tvChangePass)
    TextView tvChangePass;

    SharedPrefManager prefManager;
    String nama, email, phone,id;

    @BindView(R.id.tvNameProf)
    TextView tvNameProf;
    @BindView(R.id.tvEmailProf)
    TextView tvEmailProf;
    @BindView(R.id.tvPhoneProf)
    TextView tvPhoneProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profil);

        prefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> key = prefManager.getUserDetail();

        id = key.get(SharedPrefManager.SP_KODE_GURU);
        nama = key.get(SharedPrefManager.SP_NAME);
        email = key.get(SharedPrefManager.SP_EMAIL);
        phone = key.get(SharedPrefManager.SP_PHONE);

        loadData();
        ButterKnife.bind(this);
        setupNav("Account Setting");

    }

    private void loadData() {
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSTeacher/homeTeacher";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    j = j.getJSONObject("result");
                    JSONObject object= j.getJSONObject("Guru");
                    String nama = object.getString("nama_guru");
                    String email = object.getString("email_guru");
                    String phone = object.getString("nomor_hp");


                    tvNameProf.setText(nama);
                    tvEmailProf.setText(email);
                    tvPhoneProf.setText(phone);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("kode_guru", id)
                .setDisplayError(true)
                .execute();
    }


    @OnClick({R.id.tvChangename, R.id.tvChangeEmail, R.id.tvChangePhone, R.id.tvChangePass})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvChangename:
                startActivity(new Intent(this, ChangeName.class));
                break;
            case R.id.tvChangeEmail:
                startActivity(new Intent(this, ChangeEmail.class));
                break;
            case R.id.tvChangePhone:
                startActivity(new Intent(this, ChangePhonenumber.class));
                break;
            case R.id.tvChangePass:
                startActivity(new Intent(this, ChangePassword.class));
                break;
        }
    }
}
