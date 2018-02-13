package com.zufaralam02.sempoasip.Parent.Profil.Activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Profil.Adapters.AdapterContact;
import com.zufaralam02.sempoasip.Parent.Profil.Models.ResultContact;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Contact extends BaseActivitySempoa {

    @BindView(R.id.recyclerContact)
    RecyclerView recyclerContact;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;
    AdapterContact adapterContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);

        setupNav("Contact");

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
        pass = user.get(SharedPrefManager.SP_PASS);

        ArrayList<ResultContact> resultContact = contactData();
        adapterContact = new AdapterContact(this, resultContact, R.layout.list_contact);
        adapterContact.setNumGrid(2);
        BaseHelper.setupRecyclerView(recyclerContact, adapterContact);
//        BaseHelper.setupDragGrid(recyclerContact, adapterContact, 2);

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
                    adapterContact.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();

        return resultContact;
    }
}
