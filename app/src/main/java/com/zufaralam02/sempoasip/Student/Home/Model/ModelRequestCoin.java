package com.zufaralam02.sempoasip.Student.Home.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ModelRequestCoin {

    @SerializedName("result")
    private List<ResultRequestCoin> mResultRequestCoin;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public List<ResultRequestCoin> getResult() {
        return mResultRequestCoin;
    }

    public void setResult(List<ResultRequestCoin> resultRequestCoin) {
        mResultRequestCoin = resultRequestCoin;
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