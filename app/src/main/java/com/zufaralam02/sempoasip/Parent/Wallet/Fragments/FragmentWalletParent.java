package com.zufaralam02.sempoasip.Parent.Wallet.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.Parent.Wallet.Activities.WalletHistory;
import com.zufaralam02.sempoasip.Parent.Wallet.Adapters.AdapterWallet;
import com.zufaralam02.sempoasip.Parent.Wallet.Models.ListMurid;
import com.zufaralam02.sempoasip.R;

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
public class FragmentWalletParent extends Fragment {

    @BindView(R.id.toolbar_wallet)
    Toolbar toolbarWallet;
    @BindView(R.id.recyclerWallet)
    RecyclerView recyclerWallet;
    Unbinder unbinder;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;
    AdapterWallet adapterWallet;

    public FragmentWalletParent() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wallet_parent, container, false);
        unbinder = ButterKnife.bind(this, view);

//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_wallet);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbarWallet);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        sharedPrefManager = new SharedPrefManager(getActivity());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
        pass = user.get(SharedPrefManager.SP_PASS);

        ArrayList<ListMurid> listMurid = walletData();
        adapterWallet = new AdapterWallet(getActivity(), listMurid, R.layout.list_wallet);
        BaseHelper.setupRecyclerView(recyclerWallet, adapterWallet);

        return view;
    }

    private ArrayList<ListMurid> walletData() {
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
                        String namaSiswa = j.getString("nama_siswa");
                        String wallet = j.getString("wallet");

                        ListMurid listMurid1 = new ListMurid();
                        listMurid1.setNamaSiswa(namaSiswa);
                        listMurid1.setWallet(wallet);
                        listMurid.add(listMurid1);
                    }
                    adapterWallet.notifyDataSetChanged();
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                customDialogWallet();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//    private void setupRecyclerView() {
//        ArrayList<ModelWallet> modelWallet = walletData();
//        AdapterWallet adapterWallet = new AdapterWallet(getActivity(), modelWallet, R.layout.list_wallet);
//        BaseHelper.setupRecyclerView(recyclerWallet, adapterWallet);
//    }
//
//    private ArrayList<ModelWallet> walletData() {
//        ArrayList<ModelWallet> modelWallet = new ArrayList<>();
//
//        modelWallet.add(new ModelWallet(R.string.wallet_name1, R.string.wallet_coin1, false));
//        modelWallet.add(new ModelWallet(R.string.wallet_name2, R.string.wallet_coin2, false));
//        modelWallet.add(new ModelWallet(R.string.wallet_name3, R.string.wallet_coin3, true));
//
//        return modelWallet;
//    }

    private void customDialogWallet() {
        final BottomSheetDialog builder = new BottomSheetDialog(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.custom_dialog_wallet, null);
        builder.setContentView(view);
        builder.setCancelable(false);
        view.findViewById(R.id.cardHistory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WalletHistory.class));
                builder.cancel();
            }
        });
        view.findViewById(R.id.cardCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.cancel();
            }
        });
//        ((TextView) view.findViewById(R.id.tvTimerResult)).setText(tvCountDownTimer.getText().toString());
        builder.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
