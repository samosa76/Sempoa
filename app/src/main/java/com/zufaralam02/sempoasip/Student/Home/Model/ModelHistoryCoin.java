package com.zufaralam02.sempoasip.Student.Home.Model;

/**
 * Created by Asus on 2/12/2018.
 */

public class ModelHistoryCoin {

    private int historyNameCoin;
    private int historyTimeCoin;
    private int historyCoinCoin;

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        isPending = pending;
    }

    private boolean isPending;

    public int getHistoryNameCoin() {
        return historyNameCoin;
    }

    public void setHistoryNameStudent(int historyNameStudent) {
        this.historyNameCoin= historyNameStudent;
    }

    public int getHistoryTimeCoin() {
        return historyTimeCoin;
    }

    public void setHistoryTimeStudent(int historyTimeStudent) {
        this.historyTimeCoin= historyTimeStudent;
    }

    public int getHistoryCoinCoin() {
        return historyCoinCoin;
    }

    public void setHistoryCoinStudent(int historyCoinStudent) {
        this.historyCoinCoin= historyCoinStudent;
    }

    public ModelHistoryCoin(int historyName, int historyTime, int historyCoin, boolean isPending) {
        setHistoryNameStudent(historyName);
        setHistoryTimeStudent(historyTime);
        setHistoryCoinStudent(historyCoin);
        setPending(isPending);
    }

}
