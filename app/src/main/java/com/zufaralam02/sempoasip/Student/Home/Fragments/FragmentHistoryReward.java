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
import com.zufaralam02.sempoasip.Student.Home.Adapters.AdapterHistoryReward;
import com.zufaralam02.sempoasip.Student.Home.Model.ResultHistoryReward;

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
public class FragmentHistoryReward extends Fragment {


    @BindView(R.id.recyclerWalletHistoryStudent)
    RecyclerView recyclerWalletHistoryStudent;

    String kodeSiswa;

    Unbinder unbinder;

    SharedPrefManager sharedPrefManager;
    AdapterHistoryReward adapterHistoryReward;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_history_reward, container, false);
        unbinder = ButterKnife.bind(this, view);

        sharedPrefManager = new SharedPrefManager(getActivity());
        HashMap<String,String> key = sharedPrefManager.getUserDetail();

        kodeSiswa = key.get(sharedPrefManager.SP_KODE_SISWA);

        setUpRecylerView();

        return view;
    }

    private void setUpRecylerView() {
        ArrayList<ResultHistoryReward> modelHistoryReward = walletHistoryData();
        adapterHistoryReward = new AdapterHistoryReward(getActivity(), modelHistoryReward, R.layout.list_history_wallet_student);
        BaseHelper.setupRecyclerView(recyclerWalletHistoryStudent, adapterHistoryReward);
    }

    private ArrayList<ResultHistoryReward> walletHistoryData() {
        final ArrayList<ResultHistoryReward> modelHistoryReward= new ArrayList<>();
        HTTPImb httpImb = new HTTPImb(this,true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSChild/withdrawHistory";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    JSONArray jsonArray = j.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++){
                        j = jsonArray.getJSONObject(i);

                        String withdrawId = j.getString("withdraw_id");
                        String jumlahWithDraw = j.getString("withdraw_jumlah");
                        String createdDate = j.getString("withdraw_created_date");
                        String status = j.getString("withdraw_status");

                        ResultHistoryReward resultHistoryReward = new ResultHistoryReward();

                        resultHistoryReward.setWithdrawStatus(status);
                        resultHistoryReward.setWithdrawId(withdrawId);
                        resultHistoryReward.setWithdrawJumlah(jumlahWithDraw);
                        resultHistoryReward.setWithdrawCreatedDate(createdDate);

                        modelHistoryReward.add(resultHistoryReward);
                    }
                    adapterHistoryReward.notifyDataSetChanged();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        httpImb.setPostParams("kode_siswa" , kodeSiswa)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();

        return modelHistoryReward;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
