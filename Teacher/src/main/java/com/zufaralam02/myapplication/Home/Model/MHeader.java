package com.zufaralam02.myapplication.Home.Model;

import android.annotation.SuppressLint;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by User on 2/14/2018.
 */
@SuppressLint("ParcelCreator")
public class MHeader extends ExpandableGroup<Book> {

    public MHeader(String title, List<Book> items) {
        super(title, items);
    }
}
