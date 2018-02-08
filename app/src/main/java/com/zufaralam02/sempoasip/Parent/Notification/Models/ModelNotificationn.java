
package com.zufaralam02.sempoasip.Parent.Notification.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ModelNotificationn {

    @SerializedName("result")
    private List<ResultNotification> mResultNotification;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public List<ResultNotification> getResult() {
        return mResultNotification;
    }

    public void setResult(List<ResultNotification> resultNotification) {
        mResultNotification = resultNotification;
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
