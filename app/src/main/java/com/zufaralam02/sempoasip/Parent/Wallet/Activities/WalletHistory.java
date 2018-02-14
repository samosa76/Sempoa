package com.zufaralam02.sempoasip.Parent.Wallet.Activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.Parent.Wallet.Adapters.AdapterHistory;
import com.zufaralam02.sempoasip.Parent.Wallet.Models.ResultHistory;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WalletHistory extends BaseActivitySempoa {

    @BindView(R.id.recyclerWalletHistory)
    RecyclerView recyclerWalletHistory;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;
    AdapterHistory adapterHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_history);
        ButterKnife.bind(this);

        setupNav("SIP Wallet History");

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

        ArrayList<ResultHistory> resultHistory = historyWallet();
        adapterHistory = new AdapterHistory(this, resultHistory, R.layout.list_history_wallet);
        BaseHelper.setupRecyclerView(recyclerWalletHistory, adapterHistory);

    }

    private ArrayList<ResultHistory> historyWallet() {
        final ArrayList<ResultHistory> resultHistory = new ArrayList<>();
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/topUpHistory";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    JSONArray jsonArray = j.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        j = jsonArray.getJSONObject(i);
                        String historyName = j.getString("topup_kodesiswa");
                        String historyTime = j.getString("topup_created_date");
                        String historyCoin = j.getString("topup_jumlah");

                        ResultHistory resultHistory1 = new ResultHistory();
                        resultHistory1.setTopupKodesiswa(historyName);
                        resultHistory1.setTopupCreatedDate(historyTime);
                        resultHistory1.setTopupJumlah(historyCoin);
                        resultHistory.add(resultHistory1);
                    }
                    adapterHistory.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        httpImb.setPostParams("parent_id", id)
                .setDisplayProgress(true)
                .setDisplayProgress(false)
                .execute();

        return resultHistory;
    }

}
