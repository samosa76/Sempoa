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
import com.zufaralam02.sempoasip.R;

import org.json.JSONException;
import org.json.JSONObject;

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

    String id, name, email, hp, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_phone_number);
        ButterKnife.bind(this);

        setupNav("Change Phone Number");

        id = getIntent().getStringExtra("parent_id");
        name = getIntent().getStringExtra("parent_fullname");
        email = getIntent().getStringExtra("parent_email");
        hp = getIntent().getStringExtra("parent_hp_nr");
        pass = getIntent().getStringExtra("parent_pwd");
        tvPhoneChangePhone.setText(hp);

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
                .setPostParams("parent_hp_nr", hp)
                .setPostParams("parent_new_hp_nr", edtPhoneChangePhone)
                .setPostParams("parent_pwd", edtPassChangePhone)
                .setDisplayError(true)
                .execute();

    }
}
