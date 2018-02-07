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
import com.zufaralam02.sempoasip.R;

import org.json.JSONException;
import org.json.JSONObject;

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

    String id, name, email, hp, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        ButterKnife.bind(this);

        setupNav("Change Email");

        id = getIntent().getStringExtra("parent_id");
        name = getIntent().getStringExtra("parent_fullname");
        email = getIntent().getStringExtra("parent_email");
        hp = getIntent().getStringExtra("parent_hp_nr");
        pass = getIntent().getStringExtra("parent_pwd");
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
//                try {
//                    j = j.getJSONObject("result");
//                    String id = j.getString("parent_id");
//                    String name = j.getString("parent_fullname");
//                    String email = j.getString("parent_email");
//                    String hp = j.getString("parent_hp_nr");
//                    String pass = j.getString("parent_pwd");
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                Intent intent = new Intent(getApplicationContext(), AccountSetting.class);
                intent.putExtra("parent_id", id);
                intent.putExtra("parent_fullname", name);
                intent.putExtra("parent_email", email);
                intent.putExtra("parent_hp_nr", hp);
                intent.putExtra("parent_pwd", pass);
                startActivity(intent);
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
