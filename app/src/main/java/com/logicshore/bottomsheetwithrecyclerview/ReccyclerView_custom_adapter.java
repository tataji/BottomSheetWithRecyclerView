package com.logicshore.bottomsheetwithrecyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LENOVO on 02-08-2017.
 */

public class ReccyclerView_custom_adapter extends RecyclerView.Adapter<ReccyclerView_custom_adapter.MyViewHolder> {
    ArrayList<String> local_DetailsArrayList;
    Context local_context;
   public ReccyclerView_custom_adapter(ArrayList<String> DetailsArrayList, Context context){
       local_DetailsArrayList=DetailsArrayList;
        local_context=context;


    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView samplelist_item_tv;
        public MyViewHolder(View view) {
            super(view);
            samplelist_item_tv=(TextView)view.findViewById(R.id.smaplelist_item_tv);
        }
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sample_list_row, parent, false);
        return new MyViewHolder(itemView);
    }


    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.samplelist_item_tv.setText(local_DetailsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return local_DetailsArrayList.size();
    }


}
