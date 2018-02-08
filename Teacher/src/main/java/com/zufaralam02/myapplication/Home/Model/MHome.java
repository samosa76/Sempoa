package com.zufaralam02.myapplication.Home.Model;

/**
 * Created by User on 2/2/2018.
 */

public class MHome {
    public int getSetStudentName() {
        return setStudentName;
    }

    public void setSetStudentName(int setStudentName) {
        this.setStudentName = setStudentName;
    }

    public int getSetFoundation() {
        return setFoundation;
    }

    public void setSetFoundation(int setFoundation) {
        this.setFoundation = setFoundation;
    }

    public MHome(int setStudentName, int setFoundation) {
        setSetFoundation(setFoundation);
        setSetFoundation(setStudentName);
    }

    private int setStudentName;
   private int setFoundation;
}
