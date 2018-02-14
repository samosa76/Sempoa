package com.zufaralam02.myapplication.Home.Model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by User on 2/8/2018.
 */

public class MDetailHeader extends ExpandableGroup<MDetailChild>{
    public MDetailHeader(String title, List<MDetailChild> items) {
        super(title, items);
    }
}
