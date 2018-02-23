package com.zufaralam02.myapplication.Home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iapps.adapters.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;
import com.zufaralam02.myapplication.Home.Activity.DetailHome;
import com.zufaralam02.myapplication.Home.Model.MHome;
import com.zufaralam02.myapplication.Home.Pojo.AddStudent.Result;
import com.zufaralam02.myapplication.Home.Pojo.Home.Guru;
import com.zufaralam02.myapplication.Home.Pojo.Home.Kela;
import com.zufaralam02.myapplication.Home.Pojo.Home.PojoHome;
import com.zufaralam02.myapplication.Notification.Activity.DetailNotif;
import com.zufaralam02.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/5/2018.
 */

public class AHome extends BaseRecyclerAdapter {

    public AHome(Context context, List<?> items, int cellLayout) {
        super(context, items, cellLayout);
    }

    ArrayList<MHome> mHome = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder objectHolder(View v) {
        return new AHome.Holder(v);
    }

    @Override
    public RecyclerView.ViewHolder headerHolder(View v) {
        return null;
    }

    @Override
    public void setView(RecyclerView.ViewHolder objectHolder, int position) {
        AHome.Holder holder = (AHome.Holder) objectHolder;


        //instansiasi objek Kela
        final Kela kela = (Kela)getItem(position);
//        final PojoHome home = (PojoHome)getItem(position);
//        final com.zufaralam02.myapplication.Home.Pojo.Home.PojoHome home = (com.zufaralam02.myapplication.Home.Pojo.Home.PojoHome)getItem(position);

        holder.tvName.setText(kela.getIdRoom());
        holder.tvDateOn.setText(kela.getJamMulaiKelas());
        holder.tvDateOut.setText(kela.getJamAkhirKelas());

        holder.cvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), DetailHome .class);
                i.putExtra("namaKelas",kela.getIdRoom());
                i.putExtra("dateOn",kela.getJamMulaiKelas());
                i.putExtra("dateOut",kela.getJamAkhirKelas());
//                i.putExtra("date",home.
//                        getDate());
                getContext().startActivity(i);
            }
        });




//        AHome.Holder holder = (AHome.Holder) objectHolder;
//        final MHome modelNotification = (MHome) getItem(position);
//
//        holder.tvName.setText(modelNotification.getNameHome());
//        holder.tvDate.setText(modelNotification.getDateHome());
//        holder.cvHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent a = new Intent(getContext(), DetailHome.class);
//                a.putExtra("name", modelNotification.getNameHome());
//                a.putExtra("da", modelNotification.getDateHome());
//                getContext().startActivity(a);
//            }
//        });

    }

    @Override
    public void setHeaderView(RecyclerView.ViewHolder objectHolder) {

    }

    @Override
    public void itemSelected(int position) {

    }

    private class Holder extends RecyclerView.ViewHolder {
        // id di lv_home
        TextView tvName, tvDateOn,tvDateOut;
        CardView cvHome;

        // id di fragment_fragment_home
        TextView tvNamaGuru, tvKodeGuru, tvTc;
        ImageView imgProfHome;

        public Holder(View v) {
            super(v);
            //inisialisasi id in layout lv_home
            tvName = v.findViewById(R.id.tvName);
            tvDateOn = v.findViewById(R.id.tvDateOn);
            tvDateOut = v.findViewById(R.id.tvDateOut);
            cvHome = v.findViewById(R.id.cvHome);

            imgProfHome = v.findViewById(R.id.imgProfHome);

        }
    }
}
