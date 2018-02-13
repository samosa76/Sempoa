package com.zufaralam02.sempoasip.Student.Home.Model;

/**
 * Created by Asus on 2/12/2018.
 */

public class ModelHistoryReward {

    private int historyNameReward;
    private int historyTimeReward;
    private int historyCoinReward;
    private boolean isPending;

    public int getHistoryNameReward() {
        return historyNameReward;
    }

    public void setHistoryNameReward(int historyNameReward) {
        this.historyNameReward = historyNameReward;
    }

    public int getHistoryTimeReward() {
        return historyTimeReward;
    }

    public void setHistoryTimeReward(int historyTimeReward) {
        this.historyTimeReward = historyTimeReward;
    }

    public int getHistoryCoinReward() {
        return historyCoinReward;
    }

    public void setHistoryCoinReward(int historyCoinReward) {
        this.historyCoinReward = historyCoinReward;
    }

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        isPending = pending;
    }

    public ModelHistoryReward(int historyName, int historyTime, int historyCoin, boolean isPending) {
        setHistoryNameReward(historyName);
        setHistoryTimeReward(historyTime);
        setHistoryCoinReward(historyCoin);
        setPending(isPending);
    }

}
