
package com.zufaralam02.sempoasip.Student.Home.Model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ResultRequestCoin {

    @SerializedName("setting_coin_id")
    private String mSettingCoinId;
    @SerializedName("setting_jumlah_coin")
    private String mSettingJumlahCoin;
    @SerializedName("setting_keterangan")
    private String mSettingKeterangan;

    public String getSettingCoinId() {
        return mSettingCoinId;
    }

    public void setSettingCoinId(String settingCoinId) {
        mSettingCoinId = settingCoinId;
    }

    public String getSettingJumlahCoin() {
        return mSettingJumlahCoin;
    }

    public void setSettingJumlahCoin(String settingJumlahCoin) {
        mSettingJumlahCoin = settingJumlahCoin;
    }

    public String getSettingKeterangan() {
        return mSettingKeterangan;
    }

    public void setSettingKeterangan(String settingKeterangan) {
        mSettingKeterangan = settingKeterangan;
    }

}
