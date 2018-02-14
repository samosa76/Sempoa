package com.zufaralam02.myapplication.Home.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.Home.Adapter.ExpandableAdapter;
import com.zufaralam02.myapplication.Home.Model.Book;
import com.zufaralam02.myapplication.Home.Model.MHeader;
import com.zufaralam02.myapplication.Home.ViewHolder.HeaderViewHolder;
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

    private ArrayList<MHeader>mHeaders;
    private ExpandableAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif);
        setupNav("Class");
        ButterKnife.bind(this);

        mHeaders = new ArrayList<>();
        setData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvDetailHome.setLayoutManager(layoutManager);

        adapter = new ExpandableAdapter(this,mHeaders);
        rvDetailHome.setAdapter(adapter);
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
    }
}
