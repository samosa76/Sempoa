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

public class ChangeName extends BaseActivitySempoa {

    @BindView(R.id.tvNameChangeName)
    TextView tvNameChangeName;
    @BindView(R.id.edtNameChangeName)
    TextInputEditText edtNameChangeName;
    @BindView(R.id.edtPassChangeName)
    TextInputEditText edtPassChangeName;
    @BindView(R.id.btnSaveChangeName)
    Button btnSaveChangeName;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);
        ButterKnife.bind(this);

        setupNav("Change Name");

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

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
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/changeParentName";
            }

            @Override
            public void onSuccess(JSONObject j) {
                startActivity(new Intent(getApplicationContext(), AccountSetting.class));
                finish();
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setPostParams("parent_fullname", name)
                .setPostParams("parent_newname", edtNameChangeName)
                .setPostParams("parent_pwd", edtPassChangeName)
                .setDisplayError(true)
                .execute();
    }
}
