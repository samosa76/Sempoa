package com.zufaralam02.myapplication.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.zufaralam02.myapplication.BottomNavigation;
import com.zufaralam02.myapplication.Login.Login;

import java.util.HashMap;

/**
 * Created by User on 2/19/2018.
 */

public class SharedPrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int mode = 0;

    public static final String SP_SEMPOA_APP = "spSempoaApp";
    public static final String SP_IS_LOGIN = "spIsLogin";
    public static final String SP_TYPE = "spType";
    public static final String SP_ID = "spId";
    public static final String SP_NAME = "spName";
    public static final String SP_TC = "spTC";
    public static final String SP_EMAIL = "spEmail";
    //    public static final String SP_PASS = "spPass";
    public static final String SP_KODE_SISWA = "spKodeSiswa";
    public static final String SP_PHONE = "spPhone";
    public static final String GURU_ID = "spGuruId";
    public static final String SP_KODE_GURU = "spKodeGuru";

    @SuppressLint("CommitPrefEdits")
    public SharedPrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SP_SEMPOA_APP, mode);
        editor = sharedPreferences.edit();
    }

    //    public void sessionLogin(String id, String name, String email, String phone, String type) {
    public void sessionLogin(String name, String email, String kode, String tc,String phone) {
        editor.putBoolean(SP_IS_LOGIN, true);
        editor.putString(SP_NAME, name);
        editor.putString(SP_EMAIL, email);
        editor.putString(SP_PHONE, phone);
        editor.putString(SP_TC, tc);
        editor.putString(SP_KODE_GURU, kode);

//        editor.putString(SP_PASS, pass);
        editor.commit();
    }

    public void sessionLoginStudent(String id, String kode, String name, String type) {
        editor.putBoolean(SP_IS_LOGIN, true);
        editor.putString(SP_ID, id);
        editor.putString(SP_KODE_SISWA, kode);
        editor.putString(SP_NAME, name);
        editor.putString(SP_TYPE, type);
        editor.commit();
    }

    public void checkLogin() {
        if (!this.spIsLogin()) {
            Intent intent = new Intent(context, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
//        else if (typeLogin().trim().equals("1")) {
//            Intent intent = new Intent(context,.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        } else if (typeLogin().trim().equals("2")) {
//            Intent intent = new Intent(context, BottomNavigationStudent.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        }
        else {
            Intent intent = new Intent(context, BottomNavigation.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
//        else if (SP_TYPE.trim().equals("1")) {
//            Intent intent = new Intent(context, BottomNavigationParent.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        } else if (SP_TYPE.trim().equals("2")) {
//            Intent intent = new Intent(context, BottomNavigationStudent.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        }
//        else {
//            Intent intent = new Intent(context, BottomNavigationParent.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        }
    }

    private String typeLogin() {
        return sharedPreferences.getString(SP_TYPE, null);
    }

    private boolean spIsLogin() {
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
        user.put(SP_KODE_GURU, sharedPreferences.getString(SP_KODE_GURU, null));
        user.put(SP_TC, sharedPreferences.getString(SP_TC, null));
//        user.put(SP_PHONE, sharedPreferences.getString(SP_PHONE, null));
//        user.put(SP_PASS, sharedPreferences.getString(SP_PASS, null));
        return user;
    }


}
