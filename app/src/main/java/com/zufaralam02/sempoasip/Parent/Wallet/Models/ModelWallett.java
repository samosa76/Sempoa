
package com.zufaralam02.sempoasip.Parent.Wallet.Models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ModelWallett {

    @SerializedName("result")
    private ResultWalet mResultWalet;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public ResultWalet getResult() {
        return mResultWalet;
    }

    public void setResult(ResultWalet resultWalet) {
        mResultWalet = resultWalet;
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
