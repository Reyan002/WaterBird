package com.practiceandroid.waterbird.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Classes.TripDetail;
import com.practiceandroid.waterbird.R;
import com.practiceandroid.waterbird.TripFragment.TripDetailFragment;

import java.util.ArrayList;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripVH> {

    private ArrayList<TripDetail> list;
    private Context context;
    private FragmentManager fragmentManager;

    public TripAdapter(ArrayList<TripDetail> list, Context context, FragmentManager fragmentManager) {
        this.list = list;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public TripVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tripitem, parent, false);

        return new TripVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final TripVH holder, int position) {
        TripDetail tripDetail=list.get(position);
        holder.dateAndTime.setText(tripDetail.getDateAndTime());
        holder.companyName.setText(tripDetail.getCompanyName());
        holder.status.setText(tripDetail.getStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TripDetailFragment newFragment = new TripDetailFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.frameLayoutTrip, newFragment)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TripVH extends RecyclerView.ViewHolder{

        TextView dateAndTime,companyName,status;

        public TripVH(@NonNull View itemView) {
            super(itemView);
            dateAndTime=itemView.findViewById(R.id.datetimetrip);
            companyName=itemView.findViewById(R.id.companyNameTrip);
            status=itemView.findViewById(R.id.statustrip);
        }
    }
}
