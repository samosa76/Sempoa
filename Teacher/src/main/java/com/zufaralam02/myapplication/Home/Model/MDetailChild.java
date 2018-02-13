package com.zufaralam02.myapplication.Home.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 2/12/2018.
 */

public class MDetailChild implements Parcelable {

    protected MDetailChild(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MDetailChild> CREATOR = new Creator<MDetailChild>() {
        @Override
        public MDetailChild createFromParcel(Parcel in) {
            return new MDetailChild(in);
        }

        @Override
        public MDetailChild[] newArray(int size) {
            return new MDetailChild[size];
        }
    };
}
