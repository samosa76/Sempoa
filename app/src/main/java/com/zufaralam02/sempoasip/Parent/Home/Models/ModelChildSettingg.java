
package com.zufaralam02.sempoasip.Parent.Home.Models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ModelChildSettingg {

    @SerializedName("result")
    private ResultChildSetting mResultChildSetting;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public ResultChildSetting getResult() {
        return mResultChildSetting;
    }

    public void setResult(ResultChildSetting resultChildSetting) {
        mResultChildSetting = resultChildSetting;
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
