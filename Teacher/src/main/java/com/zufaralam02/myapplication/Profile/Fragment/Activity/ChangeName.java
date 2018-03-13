package com.zufaralam02.myapplication.Profile.Fragment.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.R;
import com.zufaralam02.myapplication.Utils.Helper;
import com.zufaralam02.myapplication.Utils.SharedPrefManager;

import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeName extends BaseActivityTeacher {

    @BindView(R.id.edtNameChangeName)
    TextInputEditText edtNameChangeName;
    @BindView(R.id.edtPassChangeName)
    TextInputEditText edtPassChangeName;
    @BindView(R.id.btnSaveChangeName)
    Button btnSaveChangeName;
    @BindView(R.id.tvNameChangeName)
    TextView tvNameChangeName;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profil2);
        ButterKnife.bind(this);
        setupNav("Change Name");
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_KODE_GURU);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);

        tvNameChangeName.setText(name);
    }

    @OnClick(R.id.btnSaveChangeName)
    public void onClick() {
        changeName();
    }

    private void changeName() {
        if (!Helper.validateEditTexts(new EditText[]{edtNameChangeName, edtPassChangeName})) {
            return;
        }
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSTeacher/changeTeacherName";
            }

            @Override
            public void onSuccess(JSONObject j) {
                startActivity(new Intent(getApplicationContext(), DetailProfil.class));
                finish();
            }
        };
        httpImb.setPostParams("kode_guru", id)
                .setPostParams("guru_fullname", name)
                .setPostParams("guru_newname", edtNameChangeName)
                .setPostParams("guru_pwd", edtPassChangeName)
                .setDisplayError(true)
                .execute();
    }
}
