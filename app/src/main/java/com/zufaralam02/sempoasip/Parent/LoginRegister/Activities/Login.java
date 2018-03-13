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
import com.zufaralam02.sempoasip.Parent.BottomNavigation.BottomNavigationParent;
import com.zufaralam02.sempoasip.Parent.Utils.Helper;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.BottomNavigation.BottomNavigationStudent;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends BaseActivitySempoa {

    @BindView(R.id.edtEmailLogin)
    TextInputEditText edtEmailLogin;
    @BindView(R.id.edtPassLogin)
    TextInputEditText edtPassLogin;
    @BindView(R.id.tvForgotPassword)
    TextView tvForgotPassword;
    @BindView(R.id.btnLoginLogin)
    Button btnLoginLogin;
    @BindView(R.id.btnRegisterLogin)
    Button btnRegisterLogin;

    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
    }

    @OnClick({R.id.tvForgotPassword, R.id.btnLoginLogin, R.id.btnRegisterLogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvForgotPassword:
                startActivity(new Intent(getApplicationContext(), ForgotPassword.class));
                break;
            case R.id.btnLoginLogin:
                requestLogin();
                break;
            case R.id.btnRegisterLogin:
                startActivity(new Intent(getApplicationContext(), Register.class));
                break;
        }
    }

    private void requestLogin() {
        if (!Helper.validateEditTexts(new EditText[]{edtEmailLogin, edtPassLogin})) {
            return;
        }
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/login";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    j = j.getJSONObject("result");
                    String type = j.getString("type");

                    if (type.trim().equalsIgnoreCase("1")) {
                        String id = j.getString("parent_id");
                        String name = j.getString("parent_fullname");
                        String email = j.getString("parent_email");
                        String hp = j.getString("parent_hp_nr");
                        String pass = j.getString("parent_pwd");
                        String type1 = j.getString("type");
                        Toast.makeText(Login.this, "Success", Toast.LENGTH_SHORT).show();
                        sharedPrefManager.sessionLogin(id, name, email, hp, pass, type1);
                        startActivity(new Intent(getApplicationContext(), BottomNavigationParent.class));
                        finish();
                    } else {
                        String id = j.getString("id_murid");
                        String kode = j.getString("kode_siswa");
                        String name = j.getString("nama_siswa");
                        String type1 = j.getString("type");
                        Toast.makeText(Login.this, "Success", Toast.LENGTH_SHORT).show();
//                        sharedPrefManager.sessionLoginStudent(id, kode, name, type1);
                        sharedPrefManager.sessionLoginStudent(id, kode, name, type1);
                        startActivity(new Intent(getApplicationContext(), BottomNavigationStudent.class));
                        finish();
                    }
//                    String id = j.getString("parent_id");
//                    String name = j.getString("parent_fullname");
//                    String email = j.getString("parent_email");
//                    String hp = j.getString("parent_hp_nr");
//                    String pass = j.getString("parent_pwd");
//                    String idMurid = j.getString("id_murid");

//                    if (email.trim().equalsIgnoreCase("1706039035")) {
////                        sharedPrefManager.sessionLogin(id, name, email, hp);
//                        startActivity(new Intent(getApplicationContext(), BottomNavigationStudent.class));
//                        finish();
//                    } else {
//                        sharedPrefManager.sessionLogin(id, name, email, hp);
//                        Toast.makeText(Login.this, idMurid, Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(), BottomNavigationParent.class));
//                        finish();
//                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("user_id", edtEmailLogin)
                .setPostParams("pwd", edtPassLogin)
                .setDisplayError(true)
                .execute();

    }
}