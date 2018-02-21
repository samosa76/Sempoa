package com.zufaralam02.myapplication.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;


import com.zufaralam02.myapplication.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by User on 2/1/2018.
 */

public abstract class BaseActivityTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void setupNav(String stringText) {
        try {
            findViewById(R.id.llBack).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            ((TextView) findViewById(R.id.tvBack)).setText(stringText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
