
package com.zufaralam02.sempoasip.Student.Home.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ModelHistoryCoin {

    @SerializedName("result")
    private List<ResultHistoryCoin> mResultHistoryCoin;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public List<ResultHistoryCoin> getResult() {
        return mResultHistoryCoin;
    }

    public void setResult(List<ResultHistoryCoin> resultHistoryCoin) {
        mResultHistoryCoin = resultHistoryCoin;
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
