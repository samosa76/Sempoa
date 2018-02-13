package com.zufaralam02.sempoasip.Student.Home.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iapps.libs.helpers.BaseHelper;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Home.Adapters.AdapterHistoryCoin;
import com.zufaralam02.sempoasip.Student.Home.Model.ModelHistoryCoin;

import java.util.ArrayList;

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

    public FragmentHistoryCoin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_history_coin, container, false);
        unbinder = ButterKnife.bind(this, view);

        setUpRecylerView();

        return view;
    }

    private void setUpRecylerView() {

        ArrayList<ModelHistoryCoin> modelHistoryCoin = walletHistoryData();
        AdapterHistoryCoin adapterHistoryCoin = new AdapterHistoryCoin(getActivity(), modelHistoryCoin, R.layout.list_history_wallet);
        BaseHelper.setupRecyclerView(recyclerWalletHistoryStudent, adapterHistoryCoin);

    }

    private ArrayList<ModelHistoryCoin> walletHistoryData() {

        ArrayList<ModelHistoryCoin> modelHistoryCoin = new ArrayList<>();

        modelHistoryCoin.add(new ModelHistoryCoin(R.string.wallet_history_name1, R.string.wallet_history_time1,
                R.string.wallet_history_coin1, true));
        modelHistoryCoin.add(new ModelHistoryCoin(R.string.wallet_history_name2, R.string.wallet_history_time2,
                R.string.wallet_history_coin2, false));
        modelHistoryCoin.add(new ModelHistoryCoin(R.string.wallet_history_name3, R.string.wallet_history_time3,
                R.string.wallet_history_coin3, false));
        modelHistoryCoin.add(new ModelHistoryCoin(R.string.wallet_history_name4, R.string.wallet_history_time4,
                R.string.wallet_history_coin4, false));
        modelHistoryCoin.add(new ModelHistoryCoin(R.string.wallet_history_name5, R.string.wallet_history_time5,
                R.string.wallet_history_coin5, true));

        return modelHistoryCoin;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
