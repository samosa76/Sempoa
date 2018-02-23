
package com.zufaralam02.myapplication.Home.Pojo.Home;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Home {

    @SerializedName("result")
    private PojoHome mResult;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public PojoHome getResult() {
        return mResult;
    }

    public void setResult(PojoHome result) {
        mResult = result;
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
