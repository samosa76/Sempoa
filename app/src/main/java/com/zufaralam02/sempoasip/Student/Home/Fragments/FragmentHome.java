package com.zufaralam02.sempoasip.Student.Home.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Home.Activities.Attandance;
import com.zufaralam02.sempoasip.Student.Home.Activities.Wallet;
import com.zufaralam02.sempoasip.Student.Notification.Activities.Notification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    @BindView(R.id.notificationHomeStudent)
    ImageView notificationHomeStudent;
    @BindView(R.id.ImageProfileStudent)
    ImageView ImageProfileStudent;
    @BindView(R.id.cardAttendance)
    CardView cardAttendance;
    @BindView(R.id.cardStudentWallet)
    CardView cardStudentWallet;

    String kodeSiswa, namaSiswa, alamatSiswa;
    SharedPrefManager sharedPrefManager;

    Unbinder unbinder;
    @BindView(R.id.tvNamaSiswa)
    TextView tvNamaSiswa;
    @BindView(R.id.tvkodeSiswa)
    TextView tvkodeSiswa;
    @BindView(R.id.tvalamat)
    TextView tvalamat;
    @BindView(R.id.tvChildWallet)
    TextView tvChildWallet;
    @BindView(R.id.tvAbsen)
    TextView tvAbsen;
    @BindView(R.id.tvCoin)
    TextView tvCoin;
    @BindView(R.id.rvIsNull)
    RelativeLayout rvIsNull;
    @BindView(R.id.nestedHome)
    NestedScrollView nestedHome;
    @BindView(R.id.tvNamaBuku1)
    TextView tvNamaBuku1;
    @BindView(R.id.tvHalBuku1)
    TextView tvHalBuku1;
    @BindView(R.id.tvNamaBuku2)
    TextView tvNamaBuku2;
    @BindView(R.id.tvHalBuku2)
    TextView tvHalBuku2;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, v);

        sharedPrefManager = new SharedPrefManager(getActivity());
        HashMap<String, String> key = sharedPrefManager.getUserDetail();

        kodeSiswa = key.get(sharedPrefManager.SP_KODE_SISWA);

        loadData();

        return v;
    }


    private void loadData() {
        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSChild/homeChild";
            }

            @Override
            public void onSuccess(JSONObject j) {
                try {
                    JSONArray jsonArray = j.getJSONArray("result");
//                    JSONObject jsonObject = jsonArray.getJSONObject()
                    for (int i = 0; i < jsonArray.length(); i++) {
                        j = jsonArray.getJSONObject(i);

//                        String namaTc  = object.getJSONObject("contact_tc").getString("nama");

                        String kodeSiswa = j.getString("kode_siswa");
                        String namaSiswa = j.getString("nama_siswa");
                        String alamat = j.getString("alamat");
                        String absen = j.getString("absen");
                        String coin = j.getString("coin");

//                        String namaBuku1  = j.getJSONObject("progress").getString("progress_total_hal_1");
                        JSONObject object = j.getJSONObject("progress");

                        String namaBuku1 = object.getString("progress_nama_buku_1");
                        String namaBuku2 = object.getString("progress_nama_buku_2");
                        String halamanBuku1 = object.getString("progress_hal_buku_1");
                        String halamanBuku2 = object.getString("progress_hal_buku_2");

                        if (jsonArray.length() == jsonArray.length()) {
                            rvIsNull.setVisibility(View.GONE);
                            nestedHome.setVisibility(View.VISIBLE);
                        }

                        tvNamaSiswa.setText(namaSiswa);
                        tvChildWallet.setText(namaSiswa + "'s Wallet");
                        tvalamat.setText(alamat);
                        tvkodeSiswa.setText(kodeSiswa);
                        tvAbsen.setText(absen);
                        tvCoin.setText(coin);
                        tvNamaBuku1.setText("Book : " +namaBuku1);
                        tvNamaBuku2.setText("Book : " +namaBuku2);
                        tvHalBuku1.setText(halamanBuku1);
                        tvHalBuku2.setText(halamanBuku2);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        httpImb.setPostParams("kode_siswa", kodeSiswa)
                .setDisplayError(true)
                .setDisplayProgress(false)
                .execute();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.notificationHomeStudent, R.id.ImageProfileStudent, R.id.cardAttendance, R.id.cardStudentWallet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.notificationHomeStudent:
                startActivity(new Intent(getActivity(), Notification.class));
                break;
            case R.id.ImageProfileStudent:
                break;
            case R.id.cardAttendance:
                startActivity(new Intent(getActivity(), Attandance.class));
                break;
            case R.id.cardStudentWallet:
                Intent i = new Intent(getActivity(), Wallet.class);
//                i.putExtra()
                startActivity(i);
                break;
        }
    }
}
