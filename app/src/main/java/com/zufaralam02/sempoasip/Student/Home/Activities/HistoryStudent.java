package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Home.Fragments.FragmentHistoryCoin;
import com.zufaralam02.sempoasip.Student.Home.Fragments.FragmentHistoryReward;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryStudent extends BaseActivitySempoa {

    @BindView(R.id.tabHistoryStudent)
    TabLayout tabHistoryStudent;
    @BindView(R.id.vpHistoryStudent)
    ViewPager vpHistoryStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_student);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupNav("History");
        setUpViewPager(vpHistoryStudent);
        tabHistoryStudent.setupWithViewPager(vpHistoryStudent);

    }

    private void setUpViewPager(ViewPager vpHistoryStudent) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentHistoryCoin(),"Coin");
        adapter.addFragment(new FragmentHistoryReward(),"Reward");
        vpHistoryStudent.setAdapter(adapter);

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String>  nameList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment (Fragment fragment, String title){
            fragmentList.add(fragment);
            nameList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return nameList.get(position);
        }
    }
}
