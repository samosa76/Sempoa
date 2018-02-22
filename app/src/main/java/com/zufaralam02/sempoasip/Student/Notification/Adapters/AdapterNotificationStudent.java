package com.zufaralam02.sempoasip.Student.Notification.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Notification.Activities.DetailNotificationStudent;
import com.zufaralam02.sempoasip.Student.Notification.Model.ResultNotificationStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2/5/2018.
 */

public class AdapterNotificationStudent extends BaseRecyclerAdapter {

    public ArrayList<ResultNotificationStudent>getModelNotificationStudent(){
        return modelNotificationStudent;
    }

    public AdapterNotificationStudent(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    ArrayList<ResultNotificationStudent>modelNotificationStudent;

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdapterNotificationStudent.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        AdapterNotificationStudent.Holder holder =  (AdapterNotificationStudent.Holder) objectHolder;
        final ResultNotificationStudent modelNotification = (ResultNotificationStudent) getItem(position);

        holder.tvTitleNotificationStudent.setText(modelNotification.getNotificationTitle());
        holder.tvDetailNotificationStudent.setText(modelNotification.getNotificationContent());
        holder.tvTimeNotificationStudent.setText(modelNotification.getNotificationCreated());
        holder.linearNotifStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),DetailNotificationStudent.class);
                i.putExtra("id",modelNotification.getNotificationId());
                i.putExtra("time",modelNotification.getNotificationCreated());
                i.putExtra("title", modelNotification.getNotificationTitle());
                i.putExtra("detail", modelNotification.getNotificationContent());
                getContext().startActivity(i);
            }
        });
    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }


    public class Holder extends RecyclerView.ViewHolder {

        TextView tvTitleNotificationStudent, tvDetailNotificationStudent, tvTimeNotificationStudent;
        ImageView ivNotificationStudent;
        LinearLayout linearNotifStudent;

        public Holder(View v) {
            super(v);

            tvTitleNotificationStudent = v.findViewById(R.id.tvTitleNotificationStudent);
            tvDetailNotificationStudent = v.findViewById(R.id.tvDetailNotificationStudent);
            tvTimeNotificationStudent = v.findViewById(R.id.tvTimeNotificationStudent);
            ivNotificationStudent = v.findViewById(R.id.ivNotificationStudent);
            linearNotifStudent = v.findViewById(R.id.linearNotifStudent);

        }
    }
}
