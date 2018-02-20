package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.Helper;
import com.zufaralam02.sempoasip.Parent.Wallet.Models.ResultCoin;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Home.Adapters.AdapterRequestCoin;
import com.zufaralam02.sempoasip.Student.Home.Model.ResultRequestCoin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RequestCoin extends BaseActivitySempoa {

    @BindView(R.id.btnRequestCoin)
    Button btnDetailRequestCoin;
    @BindView(R.id.edtRequestCoin)
    EditText edtRequestCoin;
    @BindView(R.id.rvCoinStudent)
    RecyclerView rvCoinStudent;
    String data;

    AdapterRequestCoin adapterRequestCoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_coin);
        ButterKnife.bind(this);

        setupNav("RequestCoin");

        ArrayList<ResultRequestCoin> resultRequestCoins = dataCoin();
        adapterRequestCoin = new AdapterRequestCoin(this,resultRequestCoins,R.layout.list_coin_student);
        GridLayoutManager glm = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        rvCoinStudent.setLayoutManager(glm);
        rvCoinStudent.setAdapter(adapterRequestCoin);
        adapterRequestCoin.setEdtCoin(edtRequestCoin);

    }

    private ArrayList<ResultRequestCoin> dataCoin(){
        final ArrayList<ResultRequestCoin>resultRequestCoins = new ArrayList<>();
        HTTPImb httpImb = new HTTPImb(this,true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSChild/getSettingCoin";
            }

            @Override
            public void onSuccess(JSONObject j) {

                try {
                    JSONArray jsonArray = j.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++ ){
                        j = jsonArray.getJSONObject(i);
                        String coin = j.getString("setting_jumlah_coin");
                        String keterangan = j.getString("setting_keterangan");

                        ResultRequestCoin resultCoinn = new ResultRequestCoin();
                        resultCoinn.setSettingJumlahCoin(coin);
                        resultCoinn.setSettingKeterangan(keterangan);
                        resultRequestCoins.add(resultCoinn);

                    }
                    adapterRequestCoin.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        httpImb.setDisplayError(true)
                .setDisplayProgress(false)
                .execute();

        return resultRequestCoins;
    }



    @OnClick(R.id.btnRequestCoin)
    public void onClick() {

        Intent i = new Intent(getApplicationContext(),DetailRequestCoin.class);
        i.putExtra("coin",edtRequestCoin.getText().toString());
        startActivity(i);

    }
}
