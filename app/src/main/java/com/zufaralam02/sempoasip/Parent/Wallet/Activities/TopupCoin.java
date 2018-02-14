package com.zufaralam02.sempoasip.Parent.Wallet.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.Parent.Wallet.Adapters.AdapterCoin;
import com.zufaralam02.sempoasip.Parent.Wallet.Models.ResultCoin;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopupCoin extends BaseActivitySempoa {

    @BindView(R.id.recyclerCoin)
    RecyclerView recyclerCoin;
    @BindView(R.id.edtAmountToBuy)
    TextInputEditText edtAmountToBuy;
    @BindView(R.id.edtSendTo)
    TextInputEditText edtSendTo;
    @BindView(R.id.edtPaymentMethod)
    TextInputEditText edtPaymentMethod;
    @BindView(R.id.tvPriceTopup)
    TextView tvPriceTopup;
    @BindView(R.id.btnPayNow)
    Button btnPayNow;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;
    AdapterCoin adapterCoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup_coin);
        ButterKnife.bind(this);

        setupNav("Topup Coin");

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

        ArrayList<ResultCoin> resultCoin = coinData();
        adapterCoin = new AdapterCoin(this, resultCoin, R.layout.list_coin);
        adapterCoin.setEdtAmountToBuy(edtAmountToBuy);
        adapterCoin.setTvPriceTopup(tvPriceTopup);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        recyclerCoin.setLayoutManager(layoutManager);
        recyclerCoin.setAdapter(adapterCoin);

        String namaSiswa = getIntent().getStringExtra("namaSiswa");
        edtSendTo.setText(namaSiswa);

    }

    private ArrayList<ResultCoin> coinData() {
        final ArrayList<ResultCoin> resultCoin = new ArrayList<>();
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/getSettingCoin";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    JSONArray jsonArray = j.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        j = jsonArray.getJSONObject(i);
                        String jumlahCoin = j.getString("setting_jumlah_coin");
                        String keteranganCoin = j.getString("setting_keterangan");

                        ResultCoin resultCoin1 = new ResultCoin();
                        resultCoin1.setSettingJumlahCoin(jumlahCoin);
                        resultCoin1.setSettingKeterangan(keteranganCoin);
                        resultCoin.add(resultCoin1);
                    }
                    adapterCoin.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setDisplayError(true)
                .setDisplayProgress(false)
                .execute();

        return resultCoin;
    }

    @OnClick(R.id.btnPayNow)
    public void onClick() {
        Intent intent = new Intent(getApplicationContext(), TopupCoinDetail.class);
        intent.putExtra("amount", edtAmountToBuy.getText().toString());
        intent.putExtra("price", tvPriceTopup.getText().toString());
        intent.putExtra("payment", edtPaymentMethod.getText().toString());
        intent.putExtra("name", edtSendTo.getText().toString());
        startActivity(intent);
        finish();
    }
}
