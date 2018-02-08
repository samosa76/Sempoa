package com.zufaralam02.myapplication.Home.Model;

/**
 * Created by User on 2/2/2018.
 */

public class MHome {
    public int getNameHome() {
        return nameHome;
    }

    public void setNameHome(int nameHome) {
        this.nameHome = nameHome;
    }

    public int getDateHome() {
        return dateHome;
    }

    public void setDateHome(int dateHome) {
        this.dateHome = dateHome;
    }

    public MHome(int nameHome, int dateHome) {
        setNameHome(nameHome);
        setDateHome(dateHome);
    }

    private int nameHome;
    private int dateHome;


}
