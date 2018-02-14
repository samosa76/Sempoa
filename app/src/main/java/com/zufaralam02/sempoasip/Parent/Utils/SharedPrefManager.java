package com.zufaralam02.sempoasip.Parent.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.zufaralam02.sempoasip.Parent.BottomNavigation.BottomNavigationParent;
import com.zufaralam02.sempoasip.Parent.LoginRegister.Activities.Login;

import java.util.HashMap;

/**
 * Created by user on 07/02/2018.
 */

public class SharedPrefManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int mode = 0;

    public static final String SP_SEMPOA_APP = "spSempoaApp";
    public static final String SP_IS_LOGIN = "spIsLogin";
    public static final String SP_ID = "spId";
    public static final String SP_NAME = "spName";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_PHONE = "spPhone";
//    public static final String SP_PASS = "spPass";

    @SuppressLint("CommitPrefEdits")
    public SharedPrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SP_SEMPOA_APP, mode);
        editor = sharedPreferences.edit();
    }

    public void sessionLogin(String id, String name, String email, String phone) {
        editor.putBoolean(SP_IS_LOGIN, true);
        editor.putString(SP_ID, id);
        editor.putString(SP_NAME, name);
        editor.putString(SP_EMAIL, email);
        editor.putString(SP_PHONE, phone);
//        editor.putString(SP_PASS, pass);
        editor.commit();
    }

    public void checkLogin() {
        if (!this.SP_IS_LOGIN()) {
            Intent intent = new Intent(context, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            Intent intent = new Intent(context, BottomNavigationParent.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    private boolean SP_IS_LOGIN() {
        return sharedPreferences.getBoolean(SP_IS_LOGIN, false);
    }

    public void logout() {
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(SP_SEMPOA_APP, sharedPreferences.getString(SP_SEMPOA_APP, null));
        user.put(SP_ID, sharedPreferences.getString(SP_ID, null));
        user.put(SP_NAME, sharedPreferences.getString(SP_NAME, null));
        user.put(SP_EMAIL, sharedPreferences.getString(SP_EMAIL, null));
        user.put(SP_PHONE, sharedPreferences.getString(SP_PHONE, null));
//        user.put(SP_PASS, sharedPreferences.getString(SP_PASS, null));
        return user;
    }

}
