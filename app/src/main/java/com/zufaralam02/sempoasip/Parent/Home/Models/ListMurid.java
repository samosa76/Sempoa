
package com.zufaralam02.sempoasip.Parent.Home.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ListMurid {

    @SerializedName("agama")
    private String mAgama;
    @SerializedName("alamat")
    private String mAlamat;
    @SerializedName("email_ortu")
    private String mEmailOrtu;
    @SerializedName("gambar")
    private String mGambar;
    @SerializedName("id_level_sekarang")
    private String mIdLevelSekarang;
    @SerializedName("id_murid")
    private String mIdMurid;
    @SerializedName("jenis_kelamin")
    private String mJenisKelamin;
    @SerializedName("kode_siswa")
    private String mKodeSiswa;
    @SerializedName("murid_app_pwd")
    private String mMuridAppPwd;
    @SerializedName("nama_ortu")
    private String mNamaOrtu;
    @SerializedName("nama_sekolah")
    private String mNamaSekolah;
    @SerializedName("nama_siswa")
    private String mNamaSiswa;
    @SerializedName("progress")
    private List<Progress> mProgress;
    @SerializedName("rank_Challange")
    private String mRankChallange;
    @SerializedName("tanggal_lahir")
    private String mTanggalLahir;
    @SerializedName("telepon")
    private String mTelepon;
    @SerializedName("tempat_lahir")
    private String mTempatLahir;
    @SerializedName("wallet")
    private String mWallet;

    public String getAgama() {
        return mAgama;
    }

    public void setAgama(String agama) {
        mAgama = agama;
    }

    public String getAlamat() {
        return mAlamat;
    }

    public void setAlamat(String alamat) {
        mAlamat = alamat;
    }

    public String getEmailOrtu() {
        return mEmailOrtu;
    }

    public void setEmailOrtu(String emailOrtu) {
        mEmailOrtu = emailOrtu;
    }

    public String getGambar() {
        return mGambar;
    }

    public void setGambar(String gambar) {
        mGambar = gambar;
    }

    public String getIdLevelSekarang() {
        return mIdLevelSekarang;
    }

    public void setIdLevelSekarang(String idLevelSekarang) {
        mIdLevelSekarang = idLevelSekarang;
    }

    public String getIdMurid() {
        return mIdMurid;
    }

    public void setIdMurid(String idMurid) {
        mIdMurid = idMurid;
    }

    public String getJenisKelamin() {
        return mJenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        mJenisKelamin = jenisKelamin;
    }

    public String getKodeSiswa() {
        return mKodeSiswa;
    }

    public void setKodeSiswa(String kodeSiswa) {
        mKodeSiswa = kodeSiswa;
    }

    public String getMuridAppPwd() {
        return mMuridAppPwd;
    }

    public void setMuridAppPwd(String muridAppPwd) {
        mMuridAppPwd = muridAppPwd;
    }

    public String getNamaOrtu() {
        return mNamaOrtu;
    }

    public void setNamaOrtu(String namaOrtu) {
        mNamaOrtu = namaOrtu;
    }

    public String getNamaSekolah() {
        return mNamaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        mNamaSekolah = namaSekolah;
    }

    public String getNamaSiswa() {
        return mNamaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        mNamaSiswa = namaSiswa;
    }

    public List<Progress> getProgress() {
        return mProgress;
    }

    public void setProgress(List<Progress> progress) {
        mProgress = progress;
    }

    public String getRankChallange() {
        return mRankChallange;
    }

    public void setRankChallange(String rankChallange) {
        mRankChallange = rankChallange;
    }

    public String getTanggalLahir() {
        return mTanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        mTanggalLahir = tanggalLahir;
    }

    public String getTelepon() {
        return mTelepon;
    }

    public void setTelepon(String telepon) {
        mTelepon = telepon;
    }

    public String getTempatLahir() {
        return mTempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        mTempatLahir = tempatLahir;
    }

    public String getWallet() {
        return mWallet;
    }

    public void setWallet(String wallet) {
        mWallet = wallet;
    }

}
