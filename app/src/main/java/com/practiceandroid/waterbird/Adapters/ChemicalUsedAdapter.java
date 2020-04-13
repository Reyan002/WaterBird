package com.practiceandroid.waterbird.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Classes.ChemicalUsed;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class ChemicalUsedAdapter extends RecyclerView.Adapter<ChemicalUsedAdapter.ChemicalUsedVH>{
    private Context context;
    private View view;

    private ArrayList<ChemicalUsed> list;


    public ChemicalUsedAdapter(Context context, ArrayList<ChemicalUsed> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ChemicalUsedVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.chemicaluseditem, parent, false);
        ChemicalUsedVH rvViewHolder = new ChemicalUsedVH(view);
        return rvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChemicalUsedVH holder, final int position) {

        ChemicalUsed chemicalUsed=list.get(position);

        if (chemicalUsed.getProductName()!=null) {
            holder.nam.setText(chemicalUsed.getProductName());
            holder.pdos.setText(chemicalUsed.getPresenteDosage());
            holder.rdos.setText(chemicalUsed.getRevisedDosage());
            holder.stock.setText(chemicalUsed.getStock());
        }
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position != -1 && position < list.size()) {
                    list.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, list.size());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ChemicalUsedVH extends RecyclerView.ViewHolder {
        TextView nam,pdos,rdos,stock;
        ImageView delete;

        public ChemicalUsedVH(View itemView) {
            super(itemView);
            nam = itemView.findViewById(R.id.pnametxt);
            pdos = itemView.findViewById(R.id.pdostxt);
            rdos = itemView.findViewById(R.id.rdostxt);
            stock = itemView.findViewById(R.id.stocktxt);
            delete = itemView.findViewById(R.id.deletecu);


        }}
}
