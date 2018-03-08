
package com.zufaralam02.sempoasip.Parent.Home.Models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Progress {

    @SerializedName("hal_buku")
    private String mHalBuku;
    @SerializedName("nama_buku")
    private String mNamaBuku;
    @SerializedName("progress")
    private Double mProgress;
    @SerializedName("tglUpdate")
    private String mTglUpdate;

    public String getHalBuku() {
        return mHalBuku;
    }

    public void setHalBuku(String halBuku) {
        mHalBuku = halBuku;
    }

    public String getNamaBuku() {
        return mNamaBuku;
    }

    public void setNamaBuku(String namaBuku) {
        mNamaBuku = namaBuku;
    }

    public Double getProgress() {
        return mProgress;
    }

    public void setProgress(Double progress) {
        mProgress = progress;
    }

    public String getTglUpdate() {
        return mTglUpdate;
    }

    public void setTglUpdate(String tglUpdate) {
        mTglUpdate = tglUpdate;
    }

}
