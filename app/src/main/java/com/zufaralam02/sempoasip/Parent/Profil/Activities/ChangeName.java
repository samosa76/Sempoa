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

public class ChangeName extends BaseActivitySempoa {

    @BindView(R.id.tvNameChangeName)
    TextView tvNameChangeName;
    @BindView(R.id.edtNameChangeName)
    TextInputEditText edtNameChangeName;
    @BindView(R.id.edtPassChangeName)
    TextInputEditText edtPassChangeName;
    @BindView(R.id.btnSaveChangeName)
    Button btnSaveChangeName;

    String id, name, email, hp, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);
        ButterKnife.bind(this);

        setupNav("Change Name");

        id = getIntent().getStringExtra("parent_id");
        name = getIntent().getStringExtra("parent_fullname");
        email = getIntent().getStringExtra("parent_email");
        hp = getIntent().getStringExtra("parent_hp_nr");
        pass = getIntent().getStringExtra("parent_pwd");
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
//                try {
////                    j = j.getJSONObject("result");
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
                .setPostParams("parent_fullname", name)
                .setPostParams("parent_newname", edtNameChangeName)
                .setPostParams("parent_pwd", edtPassChangeName)
                .setDisplayError(true)
                .execute();
    }
}
