package com.zufaralam02.sempoasip.Parent.Home.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Home.Adapters.AdapterChildSetting;
import com.zufaralam02.sempoasip.Parent.Home.Models.ListMurid;
import com.zufaralam02.sempoasip.Parent.LoginRegister.Activities.AddChild;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChildSetting extends BaseActivitySempoa {

    @BindView(R.id.recyclerChildSetting)
    RecyclerView recyclerChildSetting;
    @BindView(R.id.btnAddChildSetting)
    Button btnAddChildSetting;
    @BindView(R.id.btnGoToHome)
    Button btnGoToHome;
    @BindView(R.id.tvChildSettingIsNull)
    TextView tvChildSettingIsNull;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;
    AdapterChildSetting adapterChildSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_setting);
        ButterKnife.bind(this);

        setupNav("Child Setting");

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
//        name = user.get(SharedPrefManager.SP_NAME);
//        email = user.get(SharedPrefManager.SP_EMAIL);
//        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

        ArrayList<ListMurid> listMurid = childSettingData();
        adapterChildSetting = new AdapterChildSetting(this, listMurid, R.layout.list_child_setting);
        BaseHelper.setupRecyclerView(recyclerChildSetting, adapterChildSetting);
    }

    private ArrayList<ListMurid> childSettingData() {
        final ArrayList<ListMurid> listMurid = new ArrayList<>();
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/loadHomeParent";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    j = j.getJSONObject("result");
                    JSONArray jsonArray = j.getJSONArray("list murid");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        j = jsonArray.getJSONObject(i);
                        String name = j.getString("nama_siswa");
                        String code = j.getString("kode_siswa");
                        String place = j.getString("alamat");
                        String pass = j.getString("murid_app_pwd");

                        if (jsonArray.length() == jsonArray.length()) {
                            tvChildSettingIsNull.setVisibility(View.GONE);
                        }

                        ListMurid listMurid1 = new ListMurid();
                        listMurid1.setNamaSiswa(name);
                        listMurid1.setKodeSiswa(code);
                        listMurid1.setAlamat(place);
                        listMurid1.setMuridAppPwd(pass);
                        listMurid.add(listMurid1);

                    }
                    adapterChildSetting.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();

        return listMurid;
    }

    @OnClick({R.id.btnAddChildSetting, R.id.btnGoToHome})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddChildSetting:
                startActivity(new Intent(getApplicationContext(), AddChild.class));
                break;
            case R.id.btnGoToHome:
                finish();
                break;
        }
    }
}
