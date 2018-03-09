package com.zufaralam02.sempoasip.Parent.LoginRegister.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.Helper;
import com.zufaralam02.sempoasip.R;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPassword extends BaseActivitySempoa {

    @BindView(R.id.edtPassForgot)
    TextInputEditText edtPassForgot;
    @BindView(R.id.btnResetForgot)
    Button btnResetForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);

        setupNav("Forgot Password");

    }

    private void customDialogForgot() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog_forgot, null);
        builder.setView(view);
        builder.setCancelable(false);

        view.findViewById(R.id.btnOkForgot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                Toast.makeText(ForgotPassword.this, "Success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.show();
    }

    private void requestForgot() {
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/resetPwdParent";
            }

            @Override
            public void onSuccess(JSONObject j) {
                customDialogForgot();
            }

            @Override
            public void onFail(int code, JSONObject j) {
                super.onFail(code, j);
//                startActivity(new Intent(getApplicationContext(), ForgotPassword.class));
                finish();
            }
        };
        httpImb.setPostParams("parent_email", edtPassForgot)
                .setDisplayError(true)
                .execute();
    }

    @OnClick(R.id.btnResetForgot)
    public void onClick() {
        if (!Helper.validateEditTexts(new EditText[]{edtPassForgot})) {
            return;
        }
        requestForgot();
    }
}
