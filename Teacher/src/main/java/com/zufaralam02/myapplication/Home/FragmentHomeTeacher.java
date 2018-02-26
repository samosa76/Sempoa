package com.zufaralam02.myapplication.Home;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.myapplication.Home.Adapter.AHome;
import com.zufaralam02.myapplication.Home.Pojo.Home.Kela;
import com.zufaralam02.myapplication.Profile.Fragment.FragmentProfilTeacher;
import com.zufaralam02.myapplication.R;
import com.zufaralam02.myapplication.Utils.SharedPrefManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHomeTeacher extends Fragment {


    @BindView(R.id.rvHome)
    RecyclerView rvHome;
    Unbinder unbinder;
    @BindView(R.id.llhomep)
    LinearLayout llhomep;

    AHome adapter;
    String name, kode, tc, id;
    SharedPrefManager pref;

    @BindView(R.id.tvNamaGuru)
    TextView tvNamaGuru;
    @BindView(R.id.tvKodeGuru)
    TextView tvKodeGuru;
    @BindView(R.id.tvTc)
    TextView tvTc;
    @BindView(R.id.rlHome)
    RelativeLayout rlHome;
    @BindView(R.id.nestedHome)
    NestedScrollView nestedHome;

    public FragmentHomeTeacher() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home_teacher, container, false);
        unbinder = ButterKnife.bind(this, view);

        pref = new SharedPrefManager(getActivity());
        HashMap<String, String> key = pref.getUserDetail();

        name = key.get(pref.SP_NAME);
        kode = key.get(pref.SP_KODE_GURU);
        tc = key.get(pref.SP_TC);
        id = key.get(pref.SP_ID);

        ArrayList<Kela> kelas = notificationData();
        adapter = new AHome(getActivity(), kelas, R.layout.lv_home);

        BaseHelper.setupRecyclerView(rvHome, adapter);


        return view;
    }

    private ArrayList<Kela> notificationData() {
        final ArrayList<Kela> kelas = new ArrayList<>();
        HTTPImb imb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSTeacher/homeTeacher";
            }

            @Override
            public void onSuccess(JSONObject j) {

                try {
                    j = j.getJSONObject("result");
                    JSONArray array = j.getJSONArray("Kelas");
                    for (int i = 0; i < array.length(); i++) {



                        j = array.getJSONObject(i);

                        String idRoom = j.getString("id_room");
                        String timeStart = j.getString("jam_mulai_kelas");
                        String timeEnd = j.getString("jam_akhir_kelas");

                        Kela result = new Kela();
                        result.setIdRoom(idRoom);
                        result.setJamMulaiKelas(timeStart);
                        result.setJamAkhirKelas(timeEnd);
                        kelas.add(result);

                        if (j.length() == j.length()) {
                            rlHome.setVisibility(View.GONE);
                            nestedHome.setVisibility(View.VISIBLE);
                        }
                    }

                    //
                    tvNamaGuru.setText(name);
                    tvKodeGuru.setText(kode);
                    tvTc.setText(tc);

                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        imb.setPostParams("kode_guru", kode)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();
        return kelas;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    BottomNavigationView navigation;

    public BottomNavigationView getNavigation() {
        return navigation;
    }

    public void setNavigation(BottomNavigationView navigation) {
        this.navigation = navigation;
    }

    @OnClick({R.id.llhomep})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llhomep:
                FragmentProfilTeacher fmProf = new FragmentProfilTeacher();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_teacher, fmProf).commit();
                break;
        }
    }
}
