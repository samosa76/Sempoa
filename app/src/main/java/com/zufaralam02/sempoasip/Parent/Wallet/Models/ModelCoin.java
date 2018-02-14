
package com.zufaralam02.sempoasip.Parent.Wallet.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ModelCoin {

    @SerializedName("result")
    private List<ResultCoin> mResultCoin;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public List<ResultCoin> getResult() {
        return mResultCoin;
    }

    public void setResult(List<ResultCoin> resultCoin) {
        mResultCoin = resultCoin;
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
