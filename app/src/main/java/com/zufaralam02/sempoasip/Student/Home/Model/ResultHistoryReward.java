
package com.zufaralam02.sempoasip.Student.Home.Model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ResultHistoryReward {

    @SerializedName("withdraw_active")
    private String mWithdrawActive;
    @SerializedName("withdraw_created_date")
    private String mWithdrawCreatedDate;
    @SerializedName("withdraw_id")
    private String mWithdrawId;
    @SerializedName("withdraw_jumlah")
    private String mWithdrawJumlah;
    @SerializedName("withdraw_kode_siswa")
    private String mWithdrawKodeSiswa;
    @SerializedName("withdraw_nama_bank")
    private String mWithdrawNamaBank;
    @SerializedName("withdraw_nomor_bank")
    private String mWithdrawNomorBank;
    @SerializedName("withdraw_parent_id")
    private String mWithdrawParentId;
    @SerializedName("withdraw_proces_by")
    private String mWithdrawProcesBy;
    @SerializedName("withdraw_status")
    private String mWithdrawStatus;
    @SerializedName("withdraw_updated")
    private String mWithdrawUpdated;

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        isPending = pending;
    }

    boolean isPending;

    public String getWithdrawActive() {
        return mWithdrawActive;
    }

    public void setWithdrawActive(String withdrawActive) {
        mWithdrawActive = withdrawActive;
    }

    public String getWithdrawCreatedDate() {
        return mWithdrawCreatedDate;
    }

    public void setWithdrawCreatedDate(String withdrawCreatedDate) {
        mWithdrawCreatedDate = withdrawCreatedDate;
    }

    public String getWithdrawId() {
        return mWithdrawId;
    }

    public void setWithdrawId(String withdrawId) {
        mWithdrawId = withdrawId;
    }

    public String getWithdrawJumlah() {
        return mWithdrawJumlah;
    }

    public void setWithdrawJumlah(String withdrawJumlah) {
        mWithdrawJumlah = withdrawJumlah;
    }

    public String getWithdrawKodeSiswa() {
        return mWithdrawKodeSiswa;
    }

    public void setWithdrawKodeSiswa(String withdrawKodeSiswa) {
        mWithdrawKodeSiswa = withdrawKodeSiswa;
    }

    public String getWithdrawNamaBank() {
        return mWithdrawNamaBank;
    }

    public void setWithdrawNamaBank(String withdrawNamaBank) {
        mWithdrawNamaBank = withdrawNamaBank;
    }

    public String getWithdrawNomorBank() {
        return mWithdrawNomorBank;
    }

    public void setWithdrawNomorBank(String withdrawNomorBank) {
        mWithdrawNomorBank = withdrawNomorBank;
    }

    public String getWithdrawParentId() {
        return mWithdrawParentId;
    }

    public void setWithdrawParentId(String withdrawParentId) {
        mWithdrawParentId = withdrawParentId;
    }

    public String getWithdrawProcesBy() {
        return mWithdrawProcesBy;
    }

    public void setWithdrawProcesBy(String withdrawProcesBy) {
        mWithdrawProcesBy = withdrawProcesBy;
    }

    public String getWithdrawStatus() {
        return mWithdrawStatus;
    }

    public void setWithdrawStatus(String withdrawStatus) {
        mWithdrawStatus = withdrawStatus;
    }

    public String getWithdrawUpdated() {
        return mWithdrawUpdated;
    }

    public void setWithdrawUpdated(String withdrawUpdated) {
        mWithdrawUpdated = withdrawUpdated;
    }

}
