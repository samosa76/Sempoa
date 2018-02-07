package com.zufaralam02.sempoasip.Student.Home.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;
import com.zufaralam02.sempoasip.Parent.Notification.Models.Result;
import com.zufaralam02.sempoasip.R;
import com.zufaralam02.sempoasip.Student.Home.Model.ModelNotificationStudent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Asus on 2/5/2018.
 */

public class AdapterNotificationStudent extends BaseRecyclerAdapter {

    public ArrayList<ModelNotificationStudent>getModelNotificationStudent(){
        return modelNotificationStudent;
    }

    public AdapterNotificationStudent(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    public void setModelNotificationStudents(ArrayList<ModelNotificationStudent> modelNotificationStudents) {
        this.modelNotificationStudent= modelNotificationStudents;
    }

    ArrayList<ModelNotificationStudent>modelNotificationStudent;

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
        final ModelNotificationStudent modelNotification = (ModelNotificationStudent) getItem(position);

        holder.tvTitleNotificationStudent.setText(modelNotification.getTitleNotifStudent());
        holder.tvDetailNotificationStudent.setText(modelNotification.getDetailNotifStudent());
        holder.tvTimeNotificationStudent.setText(modelNotification.getTimeNotifStudent());
        Picasso.with(getContext()).load(modelNotification.getImageNotifStudent()).into(holder.ivNotificationStudent);
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
