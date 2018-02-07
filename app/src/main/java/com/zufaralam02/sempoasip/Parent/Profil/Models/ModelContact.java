
package com.zufaralam02.sempoasip.Parent.Profil.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ModelContact {

    @SerializedName("result")
    private List<ResultContact> mResultContact;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public List<ResultContact> getResult() {
        return mResultContact;
    }

    public void setResult(List<ResultContact> resultContact) {
        mResultContact = resultContact;
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
