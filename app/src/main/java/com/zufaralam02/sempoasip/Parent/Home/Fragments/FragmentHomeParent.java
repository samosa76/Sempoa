package com.zufaralam02.sempoasip.Parent.Home.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Parent.Home.Activities.LocationChild;
import com.zufaralam02.sempoasip.Parent.Home.Activities.ProgressChild;
import com.zufaralam02.sempoasip.Parent.Home.Adapters.AdapterChildHome;
import com.zufaralam02.sempoasip.Parent.LoginRegister.Activities.AddChild;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.Parent.Wallet.Fragments.FragmentWalletParent;
import com.zufaralam02.sempoasip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

//import com.zufaralam02.sempoasip.Parent.Home.Adapters.AdapterChildHome;
//import com.zufaralam02.sempoasip.Parent.Home.Models.ModelChildHome;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHomeParent extends Fragment {
    List<String[]> listChild = new ArrayList<String[]>();
    String[] childOne = {
            "Middlestone",
            "111222",
            "Tangerang"
    };
    String[] childTwo = {
            "Mark",
            "333444",
            "jakarta"
    };
    String[] childThree = {
            "Martin",
            "555666",
            "Depok"
    };

    @BindView(R.id.btnAddChildHome)
    Button btnAddChildHome;
    @BindView(R.id.viewPagerChildHome)
    ViewPager viewPagerChildHome;
    @BindView(R.id.tvProgressHome)
    TextView tvProgressHome;
    //    @BindView(R.id.tvPageBookHome)
//    TextView tvPageBookHome;
    @BindView(R.id.cardProgressHomeParent)
    CardView cardProgressHomeParent;
    @BindView(R.id.tvWalletNameHome)
    TextView tvWalletNameHome;
    @BindView(R.id.tvWalletCoinHome)
    TextView tvWalletCoinHome;
    @BindView(R.id.cardWalletHomeParent)
    CardView cardWalletHomeParent;
    @BindView(R.id.tvRankNameHome)
    TextView tvRankNameHome;
    @BindView(R.id.tvRankTypeHome)
    TextView tvRankTypeHome;
    @BindView(R.id.cardRankHomeParent)
    CardView cardRankHomeParent;
    @BindView(R.id.frameHomeParent)
    FrameLayout frameHomeParent;
    @BindView(R.id.recyclerHomeParent)
    RecyclerView recyclerHomeParent;
    Unbinder unbinder;

    AdapterChildHome adapterChildHome;
    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;

    public FragmentHomeParent() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_parent, container, false);
        unbinder = ButterKnife.bind(this, view);

        sharedPrefManager = new SharedPrefManager(getActivity());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

        requestData();

        if (adapterChildHome == null) {
//            Instead of :
//            HotelDetailPagerAdapter adapter = new HotelDetailPagerAdapter(getFragmentManager());
//            Try :
//            HotelDetailPagerAdapter adapter = new HotelDetailPagerAdapter(getChildFragmentManager());
//            and
//            Instead of :
//            FragmentTransaction ft = getBaseActivity().getFragmentManager().beginTransaction();
//            Try :
//            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
//            adapterChildHome = new AdapterChildHome(getActivity().getSupportFragmentManager());
            adapterChildHome = new AdapterChildHome(getChildFragmentManager());
            listChild.add(childOne);
            listChild.add(childTwo);
            listChild.add(childThree);
            adapterChildHome.setListChild(listChild);
//            adapterChildHome.setTvChildRank(tvChildRank);
//            adapterChildHome.setTvChildWallet(tvChildRank);

            viewPagerChildHome.setClipToPadding(false);
            viewPagerChildHome.setPadding(100, 0, 100, 0);
            viewPagerChildHome.setPageMargin(20);
            viewPagerChildHome.setSaveFromParentEnabled(false);

        }
        viewPagerChildHome.setAdapter(adapterChildHome);
        adapterChildHome.notifyDataSetChanged();

//        LocationChild locationChild = new LocationChild();
//        locationChild.setChildOne(childOne);
//        locationChild.setChildTwo(childTwo);
//        locationChild.setChildThree(childThree);

        return view;
    }

    private void requestData() {
        HTTPImb httpImb = new HTTPImb(this, false) {
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
                        String kodeSiswa = j.getString("kode_siswa");
                        String alamat = j.getString("alamat");

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setDisplayError(true)
                .execute();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btnAddChildHome, R.id.cardProgressHomeParent, R.id.cardWalletHomeParent, R.id.cardRankHomeParent})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddChildHome:
                startActivity(new Intent(getActivity(), AddChild.class));
                break;
            case R.id.cardProgressHomeParent:
                startActivity(new Intent(getActivity(), ProgressChild.class));
                break;
            case R.id.cardWalletHomeParent:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameHomeParent, new FragmentWalletParent()).commit();
                break;
            case R.id.cardRankHomeParent:
                break;
        }
    }

}
