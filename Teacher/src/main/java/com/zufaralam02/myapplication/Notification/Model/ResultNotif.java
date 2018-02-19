
package com.zufaralam02.myapplication.Notification.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ResultNotif {

    @SerializedName("result")
    private List<ResultNotifTeacher> mResultNotifTeacher;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public List<ResultNotifTeacher> getResult() {
        return mResultNotifTeacher;
    }

    public void setResult(List<ResultNotifTeacher> resultNotifTeacher) {
        mResultNotifTeacher = resultNotifTeacher;
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
