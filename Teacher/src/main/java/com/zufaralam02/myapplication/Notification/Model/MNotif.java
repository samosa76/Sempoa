package com.zufaralam02.myapplication.Notification.Model;

/**
 * Created by User on 2/2/2018.
 */

public class MNotif {
    private int titleNotif;
    private int detailNotif;
    private int timeNotif;
    private int imageNotif;
    private boolean isReaded;

    public MNotif(int titleNotif, int detailNotif, int timeNotif, int imageNotif, boolean isReaded) {
        setTitleNotif(titleNotif);
        setTimeNotif(timeNotif);
        setDetailNotif(detailNotif);
        setImageNotif(imageNotif);
        setReaded(isReaded);
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

    public int getTimeNotif() {
        return timeNotif;
    }

    public void setTimeNotif(int timeNotif) {
        this.timeNotif = timeNotif;
    }

    public int getImageNotif() {
        return imageNotif;
    }

    public void setImageNotif(int imageNotif) {
        this.imageNotif = imageNotif;
    }

    public boolean isReaded() {
        return isReaded;
    }

    public void setReaded(boolean readed) {
        isReaded = readed;
    }
}
