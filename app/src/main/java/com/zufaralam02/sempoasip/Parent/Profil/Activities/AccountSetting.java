package com.zufaralam02.sempoasip.Parent.Profil.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountSetting extends BaseActivitySempoa {

    @BindView(R.id.tvNameAccountSetting)
    TextView tvNameAccountSetting;
    @BindView(R.id.tvChangeNameAccountSetting)
    TextView tvChangeNameAccountSetting;
    @BindView(R.id.tvEmailAccountSetting)
    TextView tvEmailAccountSetting;
    @BindView(R.id.tvChangeEmailAccountSetting)
    TextView tvChangeEmailAccountSetting;
    @BindView(R.id.tvPhoneAccountSetting)
    TextView tvPhoneAccountSetting;
    @BindView(R.id.tvChangePhoneAccountSetting)
    TextView tvChangePhoneAccountSetting;
    @BindView(R.id.tvPassAccountSetting)
    TextView tvPassAccountSetting;
    @BindView(R.id.tvChangePassAccountSetting)
    TextView tvChangePassAccountSetting;

    String id, name, email, hp, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        ButterKnife.bind(this);

        setupNav("Account Setting");

//        id = getIntent().getStringExtra("parent_id");
//        name = getIntent().getStringExtra("parent_fullname");
//        email = getIntent().getStringExtra("parent_email");
//        hp = getIntent().getStringExtra("parent_hp_nr");
//        pass = getIntent().getStringExtra("parent_pwd");
//
//        tvNameAccountSetting.setText(name);
//        tvEmailAccountSetting.setText(email);
//        tvPhoneAccountSetting.setText(hp);
//        tvPassAccountSetting.setText(pass);

    }

    @Override
    protected void onResume() {
        super.onResume();
        id = getIntent().getStringExtra("parent_id");
        name = getIntent().getStringExtra("parent_fullname");
        email = getIntent().getStringExtra("parent_email");
        hp = getIntent().getStringExtra("parent_hp_nr");
        pass = getIntent().getStringExtra("parent_pwd");

        tvNameAccountSetting.setText(name);
        tvEmailAccountSetting.setText(email);
        tvPhoneAccountSetting.setText(hp);
        tvPassAccountSetting.setText(pass);
    }

    @OnClick({R.id.tvChangeNameAccountSetting, R.id.tvChangeEmailAccountSetting, R.id.tvChangePhoneAccountSetting, R.id.tvChangePassAccountSetting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvChangeNameAccountSetting:
                startActivity(new Intent(getApplicationContext(), ChangeName.class));
                Intent intent1 = new Intent(getApplicationContext(), ChangeName.class);
                intent1.putExtra("parent_id", id);
                intent1.putExtra("parent_fullname", name);
                intent1.putExtra("parent_email", email);
                intent1.putExtra("parent_hp_nr", hp);
                intent1.putExtra("parent_pwd", pass);
                startActivity(intent1);
//                finish();
                break;
            case R.id.tvChangeEmailAccountSetting:
                startActivity(new Intent(getApplicationContext(), ChangeEmail.class));
                Intent intent2 = new Intent(getApplicationContext(), ChangeEmail.class);
                intent2.putExtra("parent_id", id);
                intent2.putExtra("parent_fullname", name);
                intent2.putExtra("parent_email", email);
                intent2.putExtra("parent_hp_nr", hp);
                intent2.putExtra("parent_pwd", pass);
                startActivity(intent2);
//                finish();
                break;
            case R.id.tvChangePhoneAccountSetting:
                startActivity(new Intent(getApplicationContext(), ChangePhoneNumber.class));
                Intent intent3 = new Intent(getApplicationContext(), ChangePhoneNumber.class);
                intent3.putExtra("parent_id", id);
                intent3.putExtra("parent_fullname", name);
                intent3.putExtra("parent_email", email);
                intent3.putExtra("parent_hp_nr", hp);
                intent3.putExtra("parent_pwd", pass);
                startActivity(intent3);
//                finish();
                break;
            case R.id.tvChangePassAccountSetting:
                startActivity(new Intent(getApplicationContext(), ChangePassword.class));
                Intent intent4 = new Intent(getApplicationContext(), ChangePassword.class);
                intent4.putExtra("parent_id", id);
                intent4.putExtra("parent_fullname", name);
                intent4.putExtra("parent_email", email);
                intent4.putExtra("parent_hp_nr", hp);
                intent4.putExtra("parent_pwd", pass);
                startActivity(intent4);
//                finish();
                break;
        }
    }
}
