package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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

public class WithDraw extends BaseActivitySempoa {

    @BindView(R.id.btnWithDrawProses)
    Button btnWithDrawProses;
    @BindView(R.id.edtAmountStudent)
    EditText edtAmountStudent;
    @BindView(R.id.edtNomorBankStudent)
    EditText edtNomorBankStudent;
    @BindView(R.id.edtParentPass)
    EditText edtParentPass;

    SharedPrefManager sharedPrefManager;

    String kodeSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_draw);
        ButterKnife.bind(this);

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String,String> key = sharedPrefManager.getUserDetail();

        kodeSiswa = key.get(sharedPrefManager.SP_KODE_SISWA);

        setupNav("WithDraw");

    }

    @OnClick(R.id.btnWithDrawProses)
    public void onClick() {

        if (!Helper.validateEditTexts(new EditText[]{edtAmountStudent,edtNomorBankStudent,edtParentPass})){
            return;
        }

        HTTPImb httpImb = new HTTPImb(this,true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSChild/withdrawMurid";
            }

            @Override
            public void onSuccess(JSONObject j) {

                Intent i = new Intent(getApplicationContext(),DetailWithDraw.class);
                i.putExtra("jumlah",edtAmountStudent.getText().toString());
                startActivity(i);
            }
        };

        httpImb.setPostParams("kode_siswa",kodeSiswa)
                .setPostParams("jumlah_with_draw",edtAmountStudent)
                .setPostParams("nomor_bank",edtNomorBankStudent)
                .setPostParams("parent_pwd",edtParentPass)
                .setDisplayError(true)
                .execute();

    }
}