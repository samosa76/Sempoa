package com.zufaralam02.sempoasip.Student.Profil.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;

public class ContactStudent extends BaseActivitySempoa {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_student);

        setupNav("Contact");

    }

}
