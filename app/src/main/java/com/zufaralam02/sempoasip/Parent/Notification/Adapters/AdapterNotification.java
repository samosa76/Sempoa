package com.zufaralam02.sempoasip.Parent.Notification.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.zufaralam02.sempoasip.Parent.Notification.Activities.DetailNotification;
import com.zufaralam02.sempoasip.Parent.Notification.Models.ResultNotification;
import com.zufaralam02.sempoasip.R;

import java.util.List;

/**
 * Created by user on 18/01/2018.
 */

public class AdapterNotification extends BaseRecyclerAdapter {

    public AdapterNotification(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AdapterNotification.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        AdapterNotification.Holder holder = (AdapterNotification.Holder) objectHolder;
        final ResultNotification resultNotification = (ResultNotification) getItem(position);

        holder.tvTitleNotification.setText(resultNotification.getNotificationTitle());
        holder.tvDetailNotification.setText(resultNotification.getNotificationContent());
        holder.tvTimeNotification.setText(resultNotification.getNotificationCreated());

        holder.linearNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailNotification.class);
                intent.putExtra("notifTitle", resultNotification.getNotificationTitle());
                intent.putExtra("notifContent", resultNotification.getNotificationContent());
                intent.putExtra("notifTime", resultNotification.getNotificationCreated());
                getContext().startActivity(intent);
            }
        });

    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    private class Holder extends RecyclerView.ViewHolder {
        TextView tvTitleNotification, tvDetailNotification, tvTimeNotification;
        ImageView ivNotification;
        LinearLayout linearNotification;

        public Holder(View v) {
            super(v);
            tvTitleNotification = v.findViewById(R.id.tvTitleNotification);
            tvDetailNotification = v.findViewById(R.id.tvDetailNotification);
            tvTimeNotification = v.findViewById(R.id.tvTimeNotification);
            ivNotification = v.findViewById(R.id.ivNotification);
            linearNotification = v.findViewById(R.id.linearNotification);
        }
    }

//    public ArrayList<ModelNotification> getModelNotification() {
//        return modelNotification;
//    }
//
//    public void setModelNotification(ArrayList<ModelNotification> modelNotification) {
//        this.modelNotification = modelNotification;
//    }
//
//    ArrayList<ModelNotification> modelNotification;
//
//    public AdapterNotification(Context context, List<?> items, int cellLayout) {
//        super(context, items, cellLayout);
//    }
//
//    @Override
//    public RecyclerView.ViewHolder objectHolder(View v) {
//        return new AdapterNotification.Holder(v);
//    }
//
//    @Override
//    public RecyclerView.ViewHolder headerHolder(View v) {
//        return null;
//    }
//
//    @Override
//    public void setView(RecyclerView.ViewHolder objectHolder, final int position) {
//
//        AdapterNotification.Holder holder = (AdapterNotification.Holder) objectHolder;
//        final ModelNotification modelNotification = (ModelNotification) getItem(position);
//
//        holder.tvTitleNotification.setText(modelNotification.getTitleNotif());
//        holder.tvDetailNotification.setText(modelNotification.getDetailNotif());
//        holder.tvTimeNotification.setText(modelNotification.getTimeNotif());
////        holder.ivNotification.setImageResource(modelNotification.getImageNotif());
//        Picasso.with(getContext()).load(modelNotification.getImageNotif()).into(holder.ivNotification);
//
//        if (modelNotification.isReaded()) {
////            holder.tvTitleNotification.setTextColor(Color.parseColor("#000000"));
////            holder.tvDetailNotification.setTextColor(Color.parseColor("#000000"));
//        } else {
//            holder.tvTitleNotification.setTextColor(Color.parseColor("#fdb17e"));
//            holder.tvDetailNotification.setTextColor(Color.parseColor("#fdb17e"));
//        }
//
//        holder.linearNotif.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), DetailNotification.class);
//
//                intent.putExtra("titleNotif", modelNotification.getTitleNotif());
//                intent.putExtra("timeNotif", modelNotification.getTimeNotif());
//                intent.putExtra("detailNotif", modelNotification.getDetailNotif());
//                intent.putExtra("imageNotif", modelNotification.getImageNotif());
//
//                getContext().startActivity(intent);
//            }
//        });
//
//    }
//
//    @Override
//    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {
//
//    }
//
//    @Override
//    public void itemSelected(int position) {
//
//    }
//
//    private class Holder extends RecyclerView.ViewHolder {
//        TextView tvTitleNotification, tvDetailNotification, tvTimeNotification;
//        ImageView ivNotification;
//        LinearLayout linearNotif;
//
//        public Holder(View v) {
//            super(v);
//
//            tvTitleNotification = v.findViewById(R.id.tvTitleNotification);
//            tvDetailNotification = v.findViewById(R.id.tvDetailNotification);
//            tvTimeNotification = v.findViewById(R.id.tvTimeNotification);
//            ivNotification = v.findViewById(R.id.ivNotification);
//            linearNotif = v.findViewById(R.id.linearNotif);
//
//        }
//    }
}
