package com.zufaralam02.myapplication.Profile.Fragment.Model;

/**
 * Created by User on 2/7/2018.
 */

public class MReward {


    private int tvDateReward;
    private int tvNameReward;
    private int tvValueReward;

    public int getTvDateReward() {
        return tvDateReward;
    }

    public void setTvDateReward(int tvDateReward) {
        this.tvDateReward = tvDateReward;
    }

    public int getTvNameReward() {
        return tvNameReward;
    }

    public void setTvNameReward(int tvNameReward) {
        this.tvNameReward = tvNameReward;
    }

    public int getTvValueReward() {
        return tvValueReward;
    }

    public void setTvValueReward(int tvValueReward) {
        this.tvValueReward = tvValueReward;
    }
    public MReward(int tvDateReward, int tvNameReward, int tvValueReward) {
        setTvDateReward(tvDateReward);
        setTvNameReward(tvNameReward);
        setTvValueReward(tvValueReward);
    }


}
