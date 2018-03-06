package com.zufaralam02.sempoasip.Parent.LoginRegister.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.Helper;
import com.zufaralam02.sempoasip.R;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends BaseActivitySempoa {

    @BindView(R.id.edtNameRegister)
    TextInputEditText edtNameRegister;
    @BindView(R.id.edtEmailRegister)
    TextInputEditText edtEmailRegister;
    @BindView(R.id.edtPhoneRegister)
    TextInputEditText edtPhoneRegister;
    @BindView(R.id.edtPassRegister)
    TextInputEditText edtPassRegister;
    @BindView(R.id.btnRegisterRegister)
    Button btnRegisterRegister;
    @BindView(R.id.tvLoginRegister)
    TextView tvLoginRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btnRegisterRegister, R.id.tvLoginRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegisterRegister:
                requestRegister();
                break;
            case R.id.tvLoginRegister:
//                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                break;
        }
    }

    private void requestRegister() {
        if (!Helper.validateEditTexts(new EditText[]{edtNameRegister, edtEmailRegister, edtPhoneRegister, edtPassRegister})) {
            return;
        }
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/registerParent";
            }

            @Override
            public void onSuccess(JSONObject j) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                Toast.makeText(Register.this, "Success", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        };
        httpImb.setPostParams("parent_fullname", edtNameRegister)
                .setPostParams("parent_email", edtEmailRegister)
                .setPostParams("parent_hp_nr", edtPhoneRegister)
                .setPostParams("parent_pwd", edtPassRegister)
                .setDisplayError(true)
                .execute();
    }
}
