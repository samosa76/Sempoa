
package com.zufaralam02.myapplication.Home.Pojo.Home;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Kela {

    @SerializedName("id_kelas")
    private String mIdKelas;
    @SerializedName("id_room")
    private String mIdRoom;
    @SerializedName("jam_akhir_kelas")
    private String mJamAkhirKelas;
    @SerializedName("jam_mulai_kelas")
    private String mJamMulaiKelas;

    public String getIdKelas() {
        return mIdKelas;
    }

    public void setIdKelas(String idKelas) {
        mIdKelas = idKelas;
    }

    public String getIdRoom() {
        return mIdRoom;
    }

    public void setIdRoom(String idRoom) {
        mIdRoom = idRoom;
    }

    public String getJamAkhirKelas() {
        return mJamAkhirKelas;
    }

    public void setJamAkhirKelas(String jamAkhirKelas) {
        mJamAkhirKelas = jamAkhirKelas;
    }

    public String getJamMulaiKelas() {
        return mJamMulaiKelas;
    }

    public void setJamMulaiKelas(String jamMulaiKelas) {
        mJamMulaiKelas = jamMulaiKelas;
    }

}
