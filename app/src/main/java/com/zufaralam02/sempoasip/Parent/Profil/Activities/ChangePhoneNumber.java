package com.zufaralam02.sempoasip.Parent.Profil.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.Helper;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePhoneNumber extends BaseActivitySempoa {

    @BindView(R.id.tvPhoneChangePhone)
    TextView tvPhoneChangePhone;
    @BindView(R.id.edtPhoneChangePhone)
    TextInputEditText edtPhoneChangePhone;
    @BindView(R.id.edtPassChangePhone)
    TextInputEditText edtPassChangePhone;
    @BindView(R.id.btnSaveChangePhone)
    Button btnSaveChangePhone;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_phone_number);
        ButterKnife.bind(this);

        setupNav("Change Phone Number");

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
        pass = user.get(SharedPrefManager.SP_PASS);

        tvPhoneChangePhone.setText(phone);

    }

    @OnClick(R.id.btnSaveChangePhone)
    public void onClick() {
        changePhone();
    }

    private void changePhone() {
        if (!Helper.validateEditTexts(new EditText[]{edtPhoneChangePhone, edtPassChangePhone})) {
            return;
        }
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/changeParentPhoneNr";
            }

            @Override
            public void onSuccess(JSONObject j) {
                startActivity(new Intent(getApplicationContext(), AccountSetting.class));
//                sharedPrefManager.sessionLogin(id, name, email, phone, pass);
                finish();
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setPostParams("parent_hp_nr", phone)
                .setPostParams("parent_new_hp_nr", edtPhoneChangePhone)
                .setPostParams("parent_pwd", edtPassChangePhone)
                .setDisplayError(true)
                .execute();

    }
}
