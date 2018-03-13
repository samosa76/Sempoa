package com.zufaralam02.sempoasip.Parent.Profil.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.EditText;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.Helper;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePassword extends BaseActivitySempoa {

    @BindView(R.id.edtCurrentPassChangePass)
    TextInputEditText edtCurrentPassChangePass;
    @BindView(R.id.edtNewPassChangePass)
    TextInputEditText edtNewPassChangePass;
    @BindView(R.id.btnSaveChangePass)
    Button btnSaveChangePass;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);

        setupNav("Change Password");

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
//        name = user.get(SharedPrefManager.SP_NAME);
//        email = user.get(SharedPrefManager.SP_EMAIL);
//        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

        requestData();

    }

    private void requestData() {
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/dataLogin";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    j = j.getJSONObject("result");
//                    String id = j.getString("parent_id");
                    name = j.getString("parent_fullname");
                    email = j.getString("parent_email");
                    phone = j.getString("parent_hp_nr");
                    pass = j.getString("parent_pwd");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setDisplayError(true)
                .execute();
    }

    @OnClick(R.id.btnSaveChangePass)
    public void onClick() {
        changePass();
    }

    private void changePass() {
        if (!Helper.validateEditTexts(new EditText[]{edtNewPassChangePass, edtCurrentPassChangePass})) {
            return;
        }
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/changeParentPassword";
            }

            @Override
            public void onSuccess(JSONObject j) {
                startActivity(new Intent(getApplicationContext(), AccountSetting.class));
                finish();
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setPostParams("parent_pwd", edtCurrentPassChangePass)
                .setPostParams("parent_new_pwd", edtNewPassChangePass)
                .setDisplayError(true)
                .execute();

    }
}

