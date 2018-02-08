package com.zufaralam02.myapplication.Home.Model;

/**
 * Created by User on 2/8/2018.
 */

public class MDetailHome {
    public int getStudentName() {
        return studentName;
    }

    public void setStudentName(int studentName) {
        this.studentName = studentName;
    }

    public int getFoundation() {
        return foundation;
    }

    public void setFoundation(int foundation) {
        this.foundation = foundation;
    }

    private int studentName;
    private int foundation;

    public MDetailHome(int studentName, int foundation) {
        setStudentName(studentName);
        setFoundation(foundation);
    }
}
