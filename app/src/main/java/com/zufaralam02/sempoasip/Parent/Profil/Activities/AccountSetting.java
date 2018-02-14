package com.zufaralam02.sempoasip.Parent.Profil.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountSetting extends BaseActivitySempoa {

    @BindView(R.id.tvNameAccountSetting)
    TextView tvNameAccountSetting;
    @BindView(R.id.tvChangeNameAccountSetting)
    TextView tvChangeNameAccountSetting;
    @BindView(R.id.tvEmailAccountSetting)
    TextView tvEmailAccountSetting;
    @BindView(R.id.tvChangeEmailAccountSetting)
    TextView tvChangeEmailAccountSetting;
    @BindView(R.id.tvPhoneAccountSetting)
    TextView tvPhoneAccountSetting;
    @BindView(R.id.tvChangePhoneAccountSetting)
    TextView tvChangePhoneAccountSetting;
    @BindView(R.id.tvPassAccountSetting)
    TextView tvPassAccountSetting;
    @BindView(R.id.tvChangePassAccountSetting)
    TextView tvChangePassAccountSetting;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        ButterKnife.bind(this);

        setupNav("Account Setting");

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

//        tvNameAccountSetting.setText(name);
//        tvEmailAccountSetting.setText(email);
//        tvPhoneAccountSetting.setText(phone);
//        tvPassAccountSetting.setText(pass);

        updateData();

    }

    private void updateData() {
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/dataLogin";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    j = j.getJSONObject("result");
                    String id = j.getString("parent_id");
                    String name = j.getString("parent_fullname");
                    String email = j.getString("parent_email");
                    String phone = j.getString("parent_hp_nr");
                    String pass = j.getString("parent_pwd");

                    tvNameAccountSetting.setText(name);
                    tvEmailAccountSetting.setText(email);
                    tvPhoneAccountSetting.setText(phone);
//                    tvPassAccountSetting.setText(pass);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//    }

    @OnClick({R.id.tvChangeNameAccountSetting, R.id.tvChangeEmailAccountSetting, R.id.tvChangePhoneAccountSetting, R.id.tvChangePassAccountSetting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvChangeNameAccountSetting:
                startActivity(new Intent(getApplicationContext(), ChangeName.class));
                break;
            case R.id.tvChangeEmailAccountSetting:
                startActivity(new Intent(getApplicationContext(), ChangeEmail.class));
                break;
            case R.id.tvChangePhoneAccountSetting:
                startActivity(new Intent(getApplicationContext(), ChangePhoneNumber.class));
                break;
            case R.id.tvChangePassAccountSetting:
                startActivity(new Intent(getApplicationContext(), ChangePassword.class));
                break;
        }
    }
}
