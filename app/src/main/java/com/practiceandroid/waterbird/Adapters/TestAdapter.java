package com.practiceandroid.waterbird.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Classes.Test;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestVH>{
     private Context context;
    private View view;

    private ArrayList<Test> list;

    public TestAdapter(Context context, ArrayList<Test> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TestVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.testitem, parent, false);
        TestVH rvViewHolder = new TestVH(view);
        return rvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestVH holder, int position) {

        Test test=list.get(position);
        holder.itemName.setText(test.getName());
        holder.contolLimit.setText(test.getControlLimit());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TestVH extends RecyclerView.ViewHolder {
        TextView itemName,contolLimit,value;

        public TestVH(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.testName);
            contolLimit = itemView.findViewById(R.id.controlLimit);
            value = itemView.findViewById(R.id.testValue);


        }
    }
}
