package com.zufaralam02.sempoasip.Parent.LoginRegister.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.BottomNavigation.BottomNavigationParent;
import com.zufaralam02.sempoasip.Parent.Utils.Helper;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddChild extends BaseActivitySempoa {
    @BindView(R.id.recyclerAddChild)
    RecyclerView recyclerAddChild;
    @BindView(R.id.edtIdAddChild)
    TextInputEditText edtIdAddChild;
    @BindView(R.id.edtNameAddChild)
    TextInputEditText edtNameAddChild;
    @BindView(R.id.edtBirthAddChild)
    TextInputEditText edtBirthAddChild;
    @BindView(R.id.btnDeleteAddChild)
    Button btnDeleteAddChild;
    @BindView(R.id.btnAddAddChild)
    Button btnAddAddChild;
    @BindView(R.id.btnSaveAddChild)
    Button btnSaveAddChild;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;

    final Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener dateSetListener;
//    RecyclerView recyclerAddChild;
//    Button btnAddAddChild, btnSaveAddChild;
//    //    Button btnDeleteChild;
//    ArrayList<ModelAddChild> modelAddChild;
//    AdapterAddChild adapterAddChild;
//
//    private final String idChild[] = {
//            ""
//    };
//    private final String nameChild[] = {
//            ""
//    };
//    private final String birthChild[] = {
//            ""
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);
        ButterKnife.bind(this);

        setupNav("Add Child");
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
        pass = user.get(SharedPrefManager.SP_PASS);

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
//        initialization();
//        setupWidget();
//        setupRecycler();
    }

    private void updateLabel() {
        String myFormat = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat, Locale.US);
        edtBirthAddChild.setText(simpleDateFormat.format(calendar.getTime()));
    }

    @OnClick({R.id.btnDeleteAddChild, R.id.btnAddAddChild, R.id.btnSaveAddChild, R.id.edtBirthAddChild})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDeleteAddChild:
                break;
            case R.id.btnAddAddChild:
                break;
            case R.id.btnSaveAddChild:
                requestAddChild();
                break;
            case R.id.edtBirthAddChild:
                new DatePickerDialog(AddChild.this, dateSetListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH))
                        .show();
                break;
        }
    }

    private void requestAddChild() {
        if (!Helper.validateEditTexts(new EditText[]{edtIdAddChild, edtNameAddChild, edtBirthAddChild})) {
            return;
        }

        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/addChildByParent";
            }

            @Override
            public void onSuccess(JSONObject j) {
                startActivity(new Intent(getApplicationContext(), BottomNavigationParent.class));
                Toast.makeText(AddChild.this, "Success", Toast.LENGTH_SHORT).show();

            }
        };
        httpImb.setPostParams("parent_id", id)
                .setPostParams("kode_siswa", edtIdAddChild)
                .setPostParams("nama_siswa", edtNameAddChild)
                .setPostParams("tgl_lahir_siswa", edtBirthAddChild)
                .setDisplayError(true)
                .execute();
    }

//    private void initialization() {
//        recyclerAddChild = findViewById(R.id.recyclerAddChild);
//        btnAddAddChild = findViewById(R.id.btnAddAddChild);
//        btnSaveAddChild = findViewById(R.id.btnSaveAddChild);
////        btnDeleteChild = findViewById(R.id.btnDeleteChild);
//    }
//
//    private void setupWidget() {
//        btnAddAddChild.setOnClickListener(this);
//        btnSaveAddChild.setOnClickListener(this);
////        btnDeleteChild.setOnClickListener(this);
//    }
//
//    private void setupRecycler() {
//        modelAddChild = AddChildData();
//        adapterAddChild = new AdapterAddChild(this, modelAddChild, R.layout.list_add_child);
//        BaseHelper.setupRecyclerView(recyclerAddChild, adapterAddChild);
//        adapterAddChild.setModelAddChild1(modelAddChild);
//
//    }
//
//    private ArrayList<ModelAddChild> AddChildData() {
//
//        modelAddChild = new ArrayList<>();
//
//        for (int i = 0; i < idChild.length; i++) {
//
//            ModelAddChild modelAddChild1 = new ModelAddChild();
//            modelAddChild1.setChildId(idChild[i]);
//            modelAddChild1.setChildName(nameChild[i]);
//            modelAddChild1.setChildBirth(birthChild[i]);
//            modelAddChild.add(modelAddChild1);
//        }
//
//        return modelAddChild;
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//            case R.id.btnAddAddChild:
//                modelAddChild.add(new ModelAddChild());
//                adapterAddChild.notifyDataSetChanged();
//                break;
//
////            case R.id.btnDeleteChild:
////                if (modelAddChild.isEmpty()) {
////                    return;
////                } else {
////                    modelAddChild.remove(modelAddChild.size() - 1);
////                    adapterAddChild.notifyDataSetChanged();
////                    break;
////                }
//
//            case R.id.btnSaveAddChild:
//                startActivity(new Intent(getApplicationContext(), BottomNavigationParent.class));
//                break;
//        }
//    }

}
