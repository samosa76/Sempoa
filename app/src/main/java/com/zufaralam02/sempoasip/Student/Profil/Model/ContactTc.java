
package com.zufaralam02.sempoasip.Student.Profil.Model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ContactTc {

    @SerializedName("nama")
    private String mNama;
    @SerializedName("nomor_telp")
    private String mNomorTelp;

    public String getNama() {
        return mNama;
    }

    public void setNama(String nama) {
        mNama = nama;
    }

    public String getNomorTelp() {
        return mNomorTelp;
    }

    public void setNomorTelp(String nomorTelp) {
        mNomorTelp = nomorTelp;
    }

}
