
package com.zufaralam02.sempoasip.Parent.Wallet.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ResultWallet {

    @SerializedName("list murid")
    private List<ListMurid> mListMurid;

    public List<ListMurid> getListMurid() {
        return mListMurid;
    }

    public void setListMurid(List<ListMurid> listMurid) {
        mListMurid = listMurid;
    }

}
