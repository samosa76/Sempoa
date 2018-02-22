package com.zufaralam02.sempoasip.Student.Profil.Activities;

import android.os.Bundle;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactStudent extends BaseActivitySempoa {

    SharedPrefManager sharedPrefManager;
    String kodeSiswa, namaSiswa, alamatSiswa;
    @BindView(R.id.tvNamaTc)
    TextView tvNamaTc;
    @BindView(R.id.tvNomorTc)
    TextView tvNomorTc;
    @BindView(R.id.tvNamaIbo)
    TextView tvNamaIbo;
    @BindView(R.id.tvNomorIbo)
    TextView tvNomorIbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_student);
        ButterKnife.bind(this);

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> key = sharedPrefManager.getUserDetail();

        kodeSiswa = key.get(sharedPrefManager.SP_KODE_SISWA);

        loadData();

        setupNav("Contact");

    }

    private void loadData() {

        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSChild/homeChild";
            }

            @Override
            public void onSuccess(JSONObject j) {

                try {
                    JSONArray jsonArray = j.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = jsonArray.getJSONObject(i);

                        String namaTc = object.getJSONObject("contact_tc").getString("nama");
                        String nomorTc = object.getJSONObject("contact_tc").getString("nomor_telp");
                        String namaIbo = object.getJSONObject("contact_ibo").getString("nama");
                        String nomorIbo = object.getJSONObject("contact_ibo").getString("nomor_telp");

                        tvNamaIbo.setText(namaIbo);
                        tvNamaTc.setText(namaTc);
                        tvNomorTc.setText(nomorTc);
                        tvNomorIbo.setText(nomorIbo);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        httpImb.setPostParams("kode_siswa", kodeSiswa)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();

    }

}
