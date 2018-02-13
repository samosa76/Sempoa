
package com.zufaralam02.sempoasip.Parent.Home.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ResultChildSetting {

    @SerializedName("list murid")
    private List<ListMurid> mListMurid;

    public List<ListMurid> getListMurid() {
        return mListMurid;
    }

    public void setListMurid(List<ListMurid> listMurid) {
        mListMurid = listMurid;
    }

}
