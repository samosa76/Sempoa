package com.zufaralam02.sempoasip.Parent.Profil.Activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Profil.Adapters.AdapterContact;
import com.zufaralam02.sempoasip.Parent.Profil.Models.ResultContact;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Contact extends BaseActivitySempoa {

    @BindView(R.id.recyclerContact)
    RecyclerView recyclerContact;

    String id, name, email, hp, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);

        setupNav("Contact");
        id = getIntent().getStringExtra("parent_id");
        name = getIntent().getStringExtra("parent_fullname");
        email = getIntent().getStringExtra("parent_email");
        hp = getIntent().getStringExtra("parent_hp_nr");
        pass = getIntent().getStringExtra("parent_pwd");

        ArrayList<ResultContact> resultContact = contactData();
        AdapterContact adapterContact = new AdapterContact(this, resultContact, R.layout.list_contact);
        BaseHelper.setupRecyclerView(recyclerContact, adapterContact);

    }

    private ArrayList<ResultContact> contactData() {
        final ArrayList<ResultContact> resultContact = new ArrayList<>();
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/getMyChildTCInfo";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    JSONArray jsonArray = j.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        j = jsonArray.getJSONObject(i);
                        String contactName = j.getString("nama");
                        String contactNumber = j.getString("nomor_telp");

                        ResultContact resultContact1 = new ResultContact();
                        resultContact1.setNama(contactName);
                        resultContact1.setNomorTelp(contactNumber);
                        resultContact.add(resultContact1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("parent_id", "1")
                .setDisplayError(true)
                .execute();

        return resultContact;
    }
}
