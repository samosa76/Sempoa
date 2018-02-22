package com.zufaralam02.myapplication.Home.Activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.iapps.libs.helpers.BaseHelper;
import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.Home.Adapter.AdapterAdd;
import com.zufaralam02.myapplication.Home.Pojo.AddStudent.Result;
import com.zufaralam02.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddStudent extends BaseActivityTeacher {

    @BindView(R.id.edtSearch)
    EditText edtSearch;
    @BindView(R.id.rvAddStudent)
    RecyclerView rvAddStudent;
    @BindView(R.id.btnConfirmAdd)
    Button btnConfirmAdd;

    AdapterAdd adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        ButterKnife.bind(this);
        setupNav("Add Student");

        ArrayList<Result> mResult = setDataAdd();
        adapter = new AdapterAdd(this, mResult, R.layout.lv_add_student);
        BaseHelper.setupRecyclerView(rvAddStudent, adapter);
    }

    private ArrayList<Result> setDataAdd() {
        final ArrayList<Result> results = new ArrayList<>();
        HTTPImb imb = new HTTPImb(this, true) {
            @Override
            public String url() {

                return "http://sandbox-sempoa.indomegabyte.com/WSTeacher/getListStudentygblmadakelas";
            }

            @Override
            public void onSuccess(JSONObject j) {
//                try {
//                    j = j.getJSONObject("result");
//
//                    JSONArray jsonArray = j.getJSONArray("Kelas");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        j = jsonArray.getJSONObject(i);
//
//                    }
//                    j.getJSONObject("Guru");
//                    j.getString("kode_guru");
//
//
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                try {
                    JSONArray jsonArray = j.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        j = jsonArray.getJSONObject(i);
                        String nama = j.getString("nama_siswa");
                        String alamat = j.getString("alamat");
                        String level = j.getString("Level");

                        Result result = new Result();
                        result.setNamaSiswa(nama);
                        result.setAlamat(alamat);
                        result.setLevel(level);
                        results.add(result);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        imb.setPostParams("kelas_id", "355")
                .setPostParams("guru_id", "1")
                .setPostParams("tc_id", "40")
                .execute();
        return results;
    }

    @OnClick(R.id.btnConfirmAdd)
    public void onClick() {
    }
}
