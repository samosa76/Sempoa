package com.zufaralam02.myapplication.Home.Model;

/**
 * Created by User on 2/2/2018.
 */

public class MHome {
    private int titleNotif;
    private int detailNotif;
    private int timeNotif;
    private int imageNotif;
    private boolean isReaded;

    public MHome(int titleNotif, int detailNotif, int imageNotif) {
        setTitleNotif(titleNotif);
        setTimeNotif(timeNotif);
        setDetailNotif(detailNotif);
        setImageNotif(imageNotif);
    }

    public int getTitleNotif() {
        return titleNotif;
    }

    public void setTitleNotif(int titleNotif) {
        this.titleNotif = titleNotif;
    }

    public int getDetailNotif() {
        return detailNotif;
    }

    public void setDetailNotif(int detailNotif) {
        this.detailNotif = detailNotif;
    }

    public void setTimeNotif(int timeNotif) {
        this.timeNotif = timeNotif;
    }

    public void setImageNotif(int imageNotif) {
        this.imageNotif = imageNotif;
    }
}
