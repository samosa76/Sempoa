
package com.zufaralam02.sempoasip.Student.Home.Model;

import com.google.gson.annotations.SerializedName;
import com.zufaralam02.sempoasip.Student.Profil.Model.ModelContactIbo;
import com.zufaralam02.sempoasip.Student.Profil.Model.ContactTc;

public class ResultHomeStudent {

    @SerializedName("absen")
    private String mAbsen;
    @SerializedName("agama")
    private String mAgama;
    @SerializedName("alamat")
    private String mAlamat;
    @SerializedName("coin")
    private String mCoin;
    @SerializedName("contact_ibo")
    private ModelContactIbo mModelContactIbo;
    @SerializedName("contact_tc")
    private ContactTc mContactTc;
    @SerializedName("id_level_sekarang")
    private String mIdLevelSekarang;
    @SerializedName("id_murid")
    private String mIdMurid;
    @SerializedName("jenis_kelamin")
    private String mJenisKelamin;
    @SerializedName("kode_siswa")
    private String mKodeSiswa;
    @SerializedName("level")
    private String mLevel;
    @SerializedName("murid_ak_id")
    private String mMuridAkId;
    @SerializedName("murid_app_pwd")
    private String mMuridAppPwd;
    @SerializedName("murid_ibo_id")
    private String mMuridIboId;
    @SerializedName("murid_kpo_id")
    private String mMuridKpoId;
    @SerializedName("murid_tc_id")
    private String mMuridTcId;
    @SerializedName("nama_siswa")
    private String mNamaSiswa;
    @SerializedName("progress")
    private progress mProgress;
    @SerializedName("rewards")
    private String mRewards;
    @SerializedName("TC")
    private String mTC;
    @SerializedName("tanggal_lahir")
    private String mTanggalLahir;
    @SerializedName("tempat_lahir")
    private String mTempatLahir;

    public String getAbsen() {
        return mAbsen;
    }

    public void setAbsen(String absen) {
        mAbsen = absen;
    }

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

    public String getCoin() {
        return mCoin;
    }

    public void setCoin(String coin) {
        mCoin = coin;
    }

    public ModelContactIbo getContactIbo() {
        return mModelContactIbo;
    }

    public void setContactIbo(ModelContactIbo modelContactIbo) {
        mModelContactIbo = modelContactIbo;
    }

    public ContactTc getContactTc() {
        return mContactTc;
    }

    public void setContactTc(ContactTc contactTc) {
        mContactTc = contactTc;
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

    public String getLevel() {
        return mLevel;
    }

    public void setLevel(String level) {
        mLevel = level;
    }

    public String getMuridAkId() {
        return mMuridAkId;
    }

    public void setMuridAkId(String muridAkId) {
        mMuridAkId = muridAkId;
    }

    public String getMuridAppPwd() {
        return mMuridAppPwd;
    }

    public void setMuridAppPwd(String muridAppPwd) {
        mMuridAppPwd = muridAppPwd;
    }

    public String getMuridIboId() {
        return mMuridIboId;
    }

    public void setMuridIboId(String muridIboId) {
        mMuridIboId = muridIboId;
    }

    public String getMuridKpoId() {
        return mMuridKpoId;
    }

    public void setMuridKpoId(String muridKpoId) {
        mMuridKpoId = muridKpoId;
    }

    public String getMuridTcId() {
        return mMuridTcId;
    }

    public void setMuridTcId(String muridTcId) {
        mMuridTcId = muridTcId;
    }

    public String getNamaSiswa() {
        return mNamaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        mNamaSiswa = namaSiswa;
    }

    public progress getProgress() {
        return mProgress;
    }

    public void setProgress(progress progress) {
        mProgress = progress;
    }

    public String getRewards() {
        return mRewards;
    }

    public void setRewards(String rewards) {
        mRewards = rewards;
    }

    public String getTC() {
        return mTC;
    }

    public void setTC(String TC) {
        mTC = TC;
    }

    public String getTanggalLahir() {
        return mTanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        mTanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return mTempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        mTempatLahir = tempatLahir;
    }

}
