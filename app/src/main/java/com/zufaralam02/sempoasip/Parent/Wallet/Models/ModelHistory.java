
package com.zufaralam02.sempoasip.Parent.Wallet.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ModelHistory {

    @SerializedName("result")
    private List<ResultHistory> mResultHistory;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public List<ResultHistory> getResult() {
        return mResultHistory;
    }

    public void setResult(List<ResultHistory> resultHistory) {
        mResultHistory = resultHistory;
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
