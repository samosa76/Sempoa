
package com.zufaralam02.myapplication.Home.Pojo.Home;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PojoHome {

    @SerializedName("Date")
    private String mDate;
    @SerializedName("Guru")
    private com.zufaralam02.myapplication.Home.Pojo.Home.Guru mGuru;
    @SerializedName("Kelas")
    private List<Kela> mKelas;

    public String getDate() {
        return mDate;
    }

    public void setDate(String Date) {
        mDate = Date;
    }

    public com.zufaralam02.myapplication.Home.Pojo.Home.Guru getGuru() {
        return mGuru;
    }

    public void setGuru(com.zufaralam02.myapplication.Home.Pojo.Home.Guru Guru) {
        mGuru = Guru;
    }

    public List<Kela> getKelas() {
        return mKelas;
    }

    public void setKelas(List<Kela> Kelas) {
        mKelas = Kelas;
    }

}
