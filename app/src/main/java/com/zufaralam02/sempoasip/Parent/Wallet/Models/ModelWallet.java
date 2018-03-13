
package com.zufaralam02.sempoasip.Parent.Wallet.Models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ModelWallet {

    @SerializedName("result")
    private ResultWallet mResultWallet;
    @SerializedName("status_code")
    private Long mStatusCode;
    @SerializedName("status_message")
    private String mStatusMessage;

    public ResultWallet getResult() {
        return mResultWallet;
    }

    public void setResult(ResultWallet resultWallet) {
        mResultWallet = resultWallet;
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
