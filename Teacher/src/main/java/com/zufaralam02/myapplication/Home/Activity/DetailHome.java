package com.zufaralam02.myapplication.Home.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.Home.Adapter.ExpandableAdapter;
import com.zufaralam02.myapplication.Home.Model.Book;
import com.zufaralam02.myapplication.Home.Model.MHeader;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailHome extends BaseActivityTeacher {

    @BindView(R.id.btnAddStudent)
    Button btnAddStudent;
    @BindView(R.id.rvDetailHome)
    RecyclerView rvDetailHome;
    @BindView(R.id.tvNameDetail)
    TextView tvNameDetail;
    @BindView(R.id.tvDateDetail)
    TextView tvDateDetail;
    @BindView(R.id.tvBack)
    TextView tvBack;
    @BindView(R.id.llBack)
    LinearLayout llBack;
    @BindView(R.id.llhomep)
    LinearLayout llhomep;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ArrayList<MHeader> mHeaders;
    private ExpandableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif);
        setupNav("Class");
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mHeaders = new ArrayList<>();
        setData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvDetailHome.setLayoutManager(layoutManager);

        adapter = new ExpandableAdapter(this, mHeaders);
        rvDetailHome.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                customdialogReshedule();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void customdialogReshedule() {
        final BottomSheetDialog builder = new BottomSheetDialog(this);
        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.custom_dialog_reshedule, null);
        builder.setContentView(view);
        builder.setCancelable(false);
        view.findViewById(R.id.cardHistory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Reshedule.class));
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

    private void setData() {
        ArrayList<Book> iphones = new ArrayList<>();
        iphones.add(new Book("Book 1A"));
        iphones.add(new Book("Book 1B"));

        ArrayList<Book> nexus = new ArrayList<>();
        nexus.add(new Book("Book 1A"));
        nexus.add(new Book("Book 1B"));

        ArrayList<Book> windowPhones = new ArrayList<>();
        windowPhones.add(new Book("Book 1A"));
        windowPhones.add(new Book("Book 1B"));

        mHeaders.add(new MHeader("1. Mark", iphones));
        mHeaders.add(new MHeader("2. Denny", nexus));
        mHeaders.add(new MHeader("1. Luis", windowPhones));
    }

    @OnClick(R.id.btnAddStudent)
    public void onClick() {
        startActivity(new Intent(getApplicationContext(), AddStudent.class));
    }
}
