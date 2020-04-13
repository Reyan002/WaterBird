package com.practiceandroid.waterbird.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Classes.CustomerReview;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class CustomerReviewAdapter extends RecyclerView.Adapter<CustomerReviewAdapter.CustomerReviewVH>{

    private ArrayList<CustomerReview> list;
    private Context context;

    public CustomerReviewAdapter(ArrayList<CustomerReview> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomerReviewVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reviewitem, parent, false);

        return new CustomerReviewVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerReviewVH holder, int position) {

        CustomerReview customerReview=list.get(position);
        holder.name.setText(customerReview.getName());
        holder.icon.setText(String.valueOf(customerReview.getName().charAt(0)));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CustomerReviewVH extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name,icon;



        public CustomerReviewVH(@NonNull View itemView) {
            super(itemView);
            icon=itemView.findViewById(R.id.nameIcon);
            name=itemView.findViewById(R.id.nameText);


        }
    }
}
