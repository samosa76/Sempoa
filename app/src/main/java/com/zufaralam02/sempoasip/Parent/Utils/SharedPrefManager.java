package com.zufaralam02.sempoasip.Parent.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 07/02/2018.
 */

public class SharedPrefManager {
    public static final String SP_SEMPOA_APP = "spSempoaApp";
    public static final String SP_NAME = "spName";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_IS_LOGIN = "spIsLogin";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_SEMPOA_APP, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSPString(String keySP, String value) {
        editor.putString(keySP, value);
        editor.commit();
    }

    public void saveSPInt(String keySP, int value) {
        editor.putInt(keySP, value);
        editor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value) {
        editor.putBoolean(keySP, value);
        editor.commit();
    }

    public String getSPName() {
        return sharedPreferences.getString(SP_NAME, "");
    }

    public String getSPEmail() {
        return sharedPreferences.getString(SP_EMAIL, "");
    }

    public Boolean getSPIsLogin() {
        return sharedPreferences.getBoolean(SP_IS_LOGIN, false);
    }

}
