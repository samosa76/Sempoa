package com.zufaralam02.myapplication.Home.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.zufaralam02.myapplication.Home.Model.Book;
import com.zufaralam02.myapplication.R;

/**
 * Created by User on 2/14/2018.
 */

public class BookViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {

    private TextView tvBook;

    public BookViewHolder(View itemView) {
        super(itemView);

        tvBook = (TextView)itemView.findViewById(R.id.tvBook);

    }
    public void onBind(Book book, ExpandableGroup group) {
        tvBook.setText(book.getBook());
    }
}
