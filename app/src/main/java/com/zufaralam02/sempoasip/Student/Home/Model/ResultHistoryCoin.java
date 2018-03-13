
package com.zufaralam02.sempoasip.Student.Home.Model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ResultHistoryCoin {

    @SerializedName("topup_approved_date")
    private String mTopupApprovedDate;
    @SerializedName("topup_canceled_date")
    private String mTopupCanceledDate;
    @SerializedName("topup_carapembayaran")
    private String mTopupCarapembayaran;
    @SerializedName("topup_changed_status_by")
    private String mTopupChangedStatusBy;
    @SerializedName("topup_created_date")
    private String mTopupCreatedDate;
    @SerializedName("topup_id")
    private String mTopupId;
    @SerializedName("topup_jumlah")
    private String mTopupJumlah;
    @SerializedName("topup_kodesiswa")
    private String mTopupKodesiswa;
    @SerializedName("topup_parent_id")
    private String mTopupParentId;
    @SerializedName("topup_pending_date")
    private String mTopupPendingDate;
    @SerializedName("topup_status")
    private String mTopupStatus;

    private boolean isPending;

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        isPending = pending;
    }

    public String getTopupApprovedDate() {
        return mTopupApprovedDate;
    }

    public void setTopupApprovedDate(String topupApprovedDate) {
        mTopupApprovedDate = topupApprovedDate;
    }

    public String getTopupCanceledDate() {
        return mTopupCanceledDate;
    }

    public void setTopupCanceledDate(String topupCanceledDate) {
        mTopupCanceledDate = topupCanceledDate;
    }

    public String getTopupCarapembayaran() {
        return mTopupCarapembayaran;
    }

    public void setTopupCarapembayaran(String topupCarapembayaran) {
        mTopupCarapembayaran = topupCarapembayaran;
    }

    public String getTopupChangedStatusBy() {
        return mTopupChangedStatusBy;
    }

    public void setTopupChangedStatusBy(String topupChangedStatusBy) {
        mTopupChangedStatusBy = topupChangedStatusBy;
    }

    public String getTopupCreatedDate() {
        return mTopupCreatedDate;
    }

    public void setTopupCreatedDate(String topupCreatedDate) {
        mTopupCreatedDate = topupCreatedDate;
    }

    public String getTopupId() {
        return mTopupId;
    }

    public void setTopupId(String topupId) {
        mTopupId = topupId;
    }

    public String getTopupJumlah() {
        return mTopupJumlah;
    }

    public void setTopupJumlah(String topupJumlah) {
        mTopupJumlah = topupJumlah;
    }

    public String getTopupKodesiswa() {
        return mTopupKodesiswa;
    }

    public void setTopupKodesiswa(String topupKodesiswa) {
        mTopupKodesiswa = topupKodesiswa;
    }

    public String getTopupParentId() {
        return mTopupParentId;
    }

    public void setTopupParentId(String topupParentId) {
        mTopupParentId = topupParentId;
    }

    public String getTopupPendingDate() {
        return mTopupPendingDate;
    }

    public void setTopupPendingDate(String topupPendingDate) {
        mTopupPendingDate = topupPendingDate;
    }

    public String getTopupStatus() {
        return mTopupStatus;
    }

    public void setTopupStatus(String topupStatus) {
        mTopupStatus = topupStatus;
    }

}
