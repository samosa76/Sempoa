
package com.zufaralam02.sempoasip.Student.Home.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ModelHomeStudent {

    @SerializedName("result")
    private List<ResultHomeStudent> mResultHomeStudent;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public List<ResultHomeStudent> getResult() {
        return mResultHomeStudent;
    }

    public void setResult(List<ResultHomeStudent> resultHomeStudent) {
        mResultHomeStudent = resultHomeStudent;
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
