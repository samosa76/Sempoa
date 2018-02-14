package com.zufaralam02.myapplication.Home.ViewHolder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;
import com.zufaralam02.myapplication.R;

/**
 * Created by User on 2/14/2018.
 */

public class HeaderViewHolder extends GroupViewHolder {

    private TextView tvName,tvFoundation;

    public HeaderViewHolder(View itemView) {
        super(itemView);

        tvName = (TextView)itemView.findViewById(R.id.tvStudent);
        tvFoundation = (TextView)itemView.findViewById(R.id.tvFoundation);
    }

    @Override
    public void expand() {
        tvFoundation.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_down,0);
        Log.i("Adapter","expand");
    }

    @Override
    public void collapse() {
        tvFoundation.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_up,0);
        Log.i("Adapter","expand");
    }
    public void setTvName (ExpandableGroup group){
        tvName.setText(group.getTitle());
    }
}
