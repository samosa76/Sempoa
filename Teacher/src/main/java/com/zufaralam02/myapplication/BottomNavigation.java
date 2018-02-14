package com.zufaralam02.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.TextView;

import com.zufaralam02.myapplication.Attandance.AttandanceFragment;
import com.zufaralam02.myapplication.Base.BaseActivityTeacher;
import com.zufaralam02.myapplication.Home.FragmentHomeTeacher;
import com.zufaralam02.myapplication.Notification.FragmentNotificationTeacher;
import com.zufaralam02.myapplication.Profile.Fragment.FragmentProfilTeacher;

import java.lang.reflect.Field;

public class BottomNavigation extends BaseActivityTeacher {
        @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view){
        BottomNavigationMenuView menuView = (BottomNavigationMenuView)view.getChildAt(0);
        try{
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i =0;1< menuView.getChildCount();i++ ){
                BottomNavigationItemView item = (BottomNavigationItemView)menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e){

        }catch (IllegalAccessException e){

        }
    }
    BottomNavigation navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_teacher, new FragmentHomeTeacher()).commit();
                    return true;
                case R.id.navigation_attandance:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_teacher, new AttandanceFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_teacher, new FragmentNotificationTeacher()).commit();
                    return true;
                case R.id.navigation_profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_teacher, new FragmentProfilTeacher()).commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        TextView mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_teacher, new FragmentHomeTeacher()).commit();

        FragmentHomeTeacher fragmentHomeParent = new FragmentHomeTeacher();
        fragmentHomeParent.setNavigation(navigation);
    }

}
