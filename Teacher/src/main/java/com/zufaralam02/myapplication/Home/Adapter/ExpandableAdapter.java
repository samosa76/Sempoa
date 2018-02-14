package com.zufaralam02.myapplication.Home.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.zufaralam02.myapplication.Home.Model.Book;
import com.zufaralam02.myapplication.Home.Model.MHeader;
import com.zufaralam02.myapplication.Home.ViewHolder.BookViewHolder;
import com.zufaralam02.myapplication.Home.ViewHolder.HeaderViewHolder;
import com.zufaralam02.myapplication.R;

import java.util.List;

/**
 * Created by User on 2/14/2018.
 */

public class ExpandableAdapter extends ExpandableRecyclerViewAdapter<HeaderViewHolder,BookViewHolder> {
    private Activity activity;
    public ExpandableAdapter(Activity activity,List<? extends ExpandableGroup> groups) {
        super(groups);
        this .activity = activity;
    }

    @Override
    public HeaderViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.lv_header, parent, false);

        return new HeaderViewHolder(view);
    }

    @Override
    public BookViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.lv_child, parent, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(BookViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Book book = ((MHeader)group).getItems().get(childIndex);
        holder.onBind(book,group);
    }
    @Override
    public void onBindGroupViewHolder(HeaderViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setTvName(group);
    }
}
