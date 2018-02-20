
package com.zufaralam02.sempoasip.Student.Home.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ModelHistoryReward {

    @SerializedName("result")
    private List<ResultHistoryReward> mResultHistoryReward;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public List<ResultHistoryReward> getResult() {
        return mResultHistoryReward;
    }

    public void setResult(List<ResultHistoryReward> resultHistoryReward) {
        mResultHistoryReward = resultHistoryReward;
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
