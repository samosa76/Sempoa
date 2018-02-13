package com.zufaralam02.sempoasip.Student.Home.Model;

/**
 * Created by Asus on 2/5/2018.
 */

public class ModelNotificationStudent {

    private int titleNotifStudent;
    private int detailNotifStudent;
    private int timeNotifStudent;
    private int imageNotifStudent;

    public int getTitleNotifStudent() {
        return titleNotifStudent;
    }

    public void setTitleNotifStudent(int titleNotifStudent) {
        this.titleNotifStudent = titleNotifStudent;
    }

    public int getDetailNotifStudent() {
        return detailNotifStudent;
    }

    public void setDetailNotifStudent(int detailNotifStudent) {
        this.detailNotifStudent = detailNotifStudent;
    }

    public int getTimeNotifStudent() {
        return timeNotifStudent;
    }

    public void setTimeNotifStudent(int timeNotifStudent) {
        this.timeNotifStudent = timeNotifStudent;
    }

    public int getImageNotifStudent() {
        return imageNotifStudent;
    }

    public void setImageNotifStudent(int imageNotifStudent) {
        this.imageNotifStudent = imageNotifStudent;
    }

    public boolean isReadedStudent() {
        return isReadedStudent;
    }

    public void setReadedStudent(boolean readedStudent) {
        isReadedStudent = readedStudent;
    }

    private boolean isReadedStudent;

    public ModelNotificationStudent(int titleNotif, int detailNotif, int timeNotif, int imageNotif, boolean isReaded) {
        setTitleNotifStudent(titleNotif);
        setDetailNotifStudent(detailNotif);
        setTimeNotifStudent(timeNotif);
        setImageNotifStudent(imageNotif);
        setReadedStudent(isReaded);

    }
}