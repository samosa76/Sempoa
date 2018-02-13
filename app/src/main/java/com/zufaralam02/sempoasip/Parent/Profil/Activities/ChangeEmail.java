package com.zufaralam02.sempoasip.Parent.Profil.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.Helper;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeEmail extends BaseActivitySempoa {

    @BindView(R.id.tvEmailChangeEmail)
    TextView tvEmailChangeEmail;
    @BindView(R.id.edtEmailChangeEmail)
    TextInputEditText edtEmailChangeEmail;
    @BindView(R.id.edtPassChangeEmail)
    TextInputEditText edtPassChangeEmail;
    @BindView(R.id.btnSaveChangeEmail)
    Button btnSaveChangeEmail;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        ButterKnife.bind(this);

        setupNav("Change Email");

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
        pass = user.get(SharedPrefManager.SP_PASS);

        tvEmailChangeEmail.setText(email);

    }

    @OnClick(R.id.btnSaveChangeEmail)
    public void onClick() {
        changeEmail();
    }

    private void changeEmail() {
        if (!Helper.validateEditTexts(new EditText[]{edtEmailChangeEmail, edtPassChangeEmail})) {
            return;
        }
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/changeParentEmail";
            }

            @Override
            public void onSuccess(JSONObject j) {
                startActivity(new Intent(getApplicationContext(), AccountSetting.class));
                finish();
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setPostParams("parent_email", email)
                .setPostParams("parent_new_email", edtEmailChangeEmail)
                .setPostParams("parent_pwd", edtPassChangeEmail)
                .setDisplayError(true)
                .execute();

    }
}
