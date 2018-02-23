package com.zufaralam02.myapplication.Profile.Fragment.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.EditText;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.Home.Activity.DetailHome;
import com.zufaralam02.myapplication.R;
import com.zufaralam02.myapplication.Utils.Helper;
import com.zufaralam02.myapplication.Utils.SharedPrefManager;

import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ChangeEmail extends BaseActivityTeacher {

    SharedPrefManager pref;
    String id, email;
    @BindView(R.id.edtChangeEmail)
    TextInputEditText edtChangeEmail;
    @BindView(R.id.edtPassChangeEmail)
    TextInputEditText edtPassChangeEmail;
    @BindView(R.id.btnSaveChangeName)
    Button btnSaveChangeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        ButterKnife.bind(this);
        setupNav("Change Email");
        pref = new SharedPrefManager(getApplicationContext());
        HashMap <String,String>user = pref.getUserDetail();

        id = user.get(SharedPrefManager.SP_KODE_GURU);
        email = user.get(SharedPrefManager.SP_EMAIL);
    }

    @OnClick(R.id.btnSaveChangeName)
    public void onClick() {
        if (!Helper.validateEditTexts(new EditText[]{edtChangeEmail,edtPassChangeEmail})){
            return;
        }
        HTTPImb httpImb = new HTTPImb(this,true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSTeacher/changeTeacherEmail";
            }

            @Override
            public void onSuccess(JSONObject j) {
                startActivity(new Intent(getApplicationContext(), DetailProfil.class));
                finish();
            }
        };
        httpImb.setPostParams("kode_guru",id)
                .setPostParams("guru_email",email)
                .setPostParams("guru_newemail",edtChangeEmail)
                .setPostParams("guru_pwd",edtPassChangeEmail)
                .execute();
    }
}
