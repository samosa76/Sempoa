package com.zufaralam02.sempoasip.Student.Home.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Home.Adapters.AdapterHistoryCoin;
import com.zufaralam02.sempoasip.Student.Home.Model.ModelHistoryCoin;
import com.zufaralam02.sempoasip.Student.Home.Model.ResultHistoryCoin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHistoryCoin extends Fragment {


    @BindView(R.id.recyclerWalletHistoryStudent)
    RecyclerView recyclerWalletHistoryStudent;
    Unbinder unbinder;

    String kodeSiswa;

    SharedPrefManager sharedPrefManager;
    AdapterHistoryCoin adapterHistoryCoin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_history_coin, container, false);
        unbinder = ButterKnife.bind(this, view);

        sharedPrefManager = new SharedPrefManager(getActivity());
        HashMap<String,String> key = sharedPrefManager.getUserDetail();

        kodeSiswa = key.get(sharedPrefManager.SP_KODE_SISWA);

        setUpRecylerView();

        return view;
    }

    private void setUpRecylerView() {

        ArrayList<ResultHistoryCoin> modelHistoryCoin = walletHistoryData();
        adapterHistoryCoin = new AdapterHistoryCoin(getActivity(), modelHistoryCoin, R.layout.list_history_wallet_student);
        BaseHelper.setupRecyclerView(recyclerWalletHistoryStudent, adapterHistoryCoin);

    }

    private ArrayList<ResultHistoryCoin> walletHistoryData() {

        final ArrayList<ResultHistoryCoin> modelHistoryCoin = new ArrayList<>();
        HTTPImb httpImb = new HTTPImb(this,true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSChild/coinsHistory";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    JSONArray jsonArray = j.getJSONArray("result");
                    for(int i = 0; i <jsonArray.length(); i++ ){
                        j = jsonArray.getJSONObject(i);

//                        meggunakan dua json array
//                        JSONArray jsonArray1 = j.getJSONArray("")

                        String topupId = j.getString("topup_id");
                        String topupCreatedDate = j.getString("topup_created_date");
                        String topupChangStatus = j.getString("topup_changed_status_by");
                        String jumlahCoin = j.getString("topup_jumlah");
                        String topupStats = j.getString("topup_status");

                        ResultHistoryCoin resultHistoryCoin = new ResultHistoryCoin();

                        resultHistoryCoin.setTopupId(topupId);
                        resultHistoryCoin.setTopupCreatedDate(topupCreatedDate);
                        resultHistoryCoin.setTopupChangedStatusBy(topupChangStatus);
                        resultHistoryCoin.setTopupJumlah(jumlahCoin);
                        resultHistoryCoin.setTopupStatus(topupStats);

                        modelHistoryCoin.add(resultHistoryCoin);
                    }
                    adapterHistoryCoin.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        httpImb.setPostParams("kode_siswa" , kodeSiswa)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();

        return modelHistoryCoin;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
