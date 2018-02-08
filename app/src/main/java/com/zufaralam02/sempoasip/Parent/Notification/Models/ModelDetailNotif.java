
package com.zufaralam02.sempoasip.Parent.Notification.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ModelDetailNotif {

    @SerializedName("result")
    private List<ResultDetailNotif> mResultDetailNotif;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public List<ResultDetailNotif> getResult() {
        return mResultDetailNotif;
    }

    public void setResult(List<ResultDetailNotif> resultDetailNotif) {
        mResultDetailNotif = resultDetailNotif;
    }

    public Long getStatusCode() {
        return mStatusCode;
    }

    public void setStatusCode(Long statusCode) {
        mStatusCode = statusCode;
    }

    public String getStatusMessage() {
        return mStatusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        mStatusMessage = statusMessage;
    }

}
