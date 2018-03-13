    package com.zufaralam02.myapplication.Login;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.design.widget.TextInputEditText;
    import android.support.v7.app.AppCompatActivity;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.iapps.libs.helpers.HTTPImb;
    import com.zufaralam02.myapplication.BottomNavigation;
    import com.zufaralam02.myapplication.R;
    import com.zufaralam02.myapplication.Utils.Helper;
    import com.zufaralam02.myapplication.Utils.SharedPrefManager;

    import org.json.JSONException;
    import org.json.JSONObject;

    import butterknife.BindView;
    import butterknife.ButterKnife;
    import butterknife.OnClick;

    public class Login extends AppCompatActivity {

        @BindView(R.id.edtEmailLogin)
        TextInputEditText edtEmailLogin;
        @BindView(R.id.edtPassLogin)
        TextInputEditText edtPassLogin;
        @BindView(R.id.tvForgotPassword)
        TextView tvForgotPassword;
        @BindView(R.id.btnLoginLogin)
        Button btnLoginLogin;

        SharedPrefManager sharedPrefManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            ButterKnife.bind(this);

            sharedPrefManager = new SharedPrefManager(getApplicationContext());
        }

        @OnClick(R.id.btnLoginLogin)
        public void onClick() {
            requestLogin();
        }

        private void requestLogin() {
            if (!Helper.validateEditTexts(new EditText[]{edtEmailLogin, edtPassLogin})) {
                return;
            }
            HTTPImb httpImb = new HTTPImb(this, true) {
                @Override
                public String url() {
                    return "http://sandbox-sempoa.indomegabyte.com/WSTeacher/loginTeacher";
                }

                @Override
                public void onSuccess(JSONObject j) {
                    try {
                        j = j.getJSONObject("results");

                        String name = j.getString("nama_guru");
                        String kode = j.getString("kode_guru");
                        String tc = j.getJSONObject("TC").getString("nama");
                        String phone = j.getJSONObject("TC").getString("nomor_telp");
                        String email = j.getString("email_guru");

                        Toast.makeText(Login.this, name, Toast.LENGTH_SHORT).show();
                        sharedPrefManager.sessionLogin(name,email,kode,tc,phone);
//                        startActivity(new Intent(getApplicationContext(), BottomNavigation.class));
                        finish();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            httpImb.setPostParams("kode_guru", edtEmailLogin)
                    .setPostParams("teache_pwd", edtPassLogin)
                    .setDisplayError(true)
                    .execute();
        }
    }
