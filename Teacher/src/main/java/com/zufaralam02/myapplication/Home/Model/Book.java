package com.zufaralam02.myapplication.Home.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 2/14/2018.
 */

public class Book implements Parcelable {
    private String book;
    protected Book(Parcel in) {
        book = in.readString();
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Book(String book) {
        this.book = book;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(book);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
