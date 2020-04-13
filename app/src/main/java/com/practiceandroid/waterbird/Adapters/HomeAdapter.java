package com.practiceandroid.waterbird.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Activities.CustomerReviewActivity;
import com.practiceandroid.waterbird.Activities.DashBoardActivity;
import com.practiceandroid.waterbird.Activities.HistoryActivity;
import com.practiceandroid.waterbird.Activities.ScheduleActivity;
import com.practiceandroid.waterbird.Activities.TestActivity;
import com.practiceandroid.waterbird.Classes.HomeItems;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private ArrayList<HomeItems> list;
    private Context context;

    public HomeAdapter(ArrayList<HomeItems> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public ImageView imageView;
        public CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.name);
            imageView=itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.cardHome);
        }
    }



    // Create new views (invoked by the layout manager)
    @Override
    public  MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem, parent, false);

        return new MyViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.textView.setText(mDataset[position]);
        holder.textView.setText(list.get(position).getName());
        holder.imageView.setImageResource(list.get(position).getPic());
        holder.cardView.setBackgroundColor(Color.parseColor(list.get(position).getColor()));
        if(position==0) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(v.getContext(), DashBoardActivity.class));
                }
            });
        }
        if(position==2) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(v.getContext(), TestActivity.class));
                }
            });
        }
        if(position==1) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(v.getContext(), ScheduleActivity.class));
                }
            });
        }
        if(position==4) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(v.getContext(), HistoryActivity.class));
                }
            });
        }
        if(position==3) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(v.getContext(), CustomerReviewActivity.class));
                }
            });
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }
}
