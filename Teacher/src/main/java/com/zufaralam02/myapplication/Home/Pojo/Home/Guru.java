
package com.zufaralam02.myapplication.Home.Pojo.Home;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Guru {

    @SerializedName("email_guru")
    private String mEmailGuru;
    @SerializedName("guru_id")
    private String mGuruId;
    @SerializedName("guru_tc_id")
    private String mGuruTcId;
    @SerializedName("kode_guru")
    private String mKodeGuru;
    @SerializedName("nama_guru")
    private String mNamaGuru;
    @SerializedName("TC")
    private String mTC;

    public String getEmailGuru() {
        return mEmailGuru;
    }

    public void setEmailGuru(String emailGuru) {
        mEmailGuru = emailGuru;
    }

    public String getGuruId() {
        return mGuruId;
    }

    public void setGuruId(String guruId) {
        mGuruId = guruId;
    }

    public String getGuruTcId() {
        return mGuruTcId;
    }

    public void setGuruTcId(String guruTcId) {
        mGuruTcId = guruTcId;
    }

    public String getKodeGuru() {
        return mKodeGuru;
    }

    public void setKodeGuru(String kodeGuru) {
        mKodeGuru = kodeGuru;
    }

    public String getNamaGuru() {
        return mNamaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        mNamaGuru = namaGuru;
    }

    public String getTC() {
        return mTC;
    }

    public void setTC(String TC) {
        mTC = TC;
    }

}
