package com.practiceandroid.waterbird.Adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.practiceandroid.waterbird.Classes.DemoClass;
import com.practiceandroid.waterbird.Classes.LocationItems;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {
    private Context context;
    private ArrayList<LocationItems> models;
    private View view;

    public RvAdapter(Context context, ArrayList<LocationItems> models ) {
        this.context = context;
        this.models = models;
     }

    @Override
    public RvAdapter.RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        RvViewHolder rvViewHolder = new RvViewHolder(view);
        return rvViewHolder;
    }
    @Override
    public void onBindViewHolder(final RvAdapter.RvViewHolder holder, final int position) {


        final LocationItems model = models.get(position);
//        if(!TextUtils.isEmpty(holder.loc.getText())) {
//            DemoClass.location.add(position, holder.loc.getText().toString());
//        }
        if (model.getName() != null) {
            holder.itemName.setText(model.getName());


        }
        final int pos=position+2;
        holder.loc.setHint("Location "+ pos );
//        if(!TextUtils.isEmpty(holder.loc.getText().toString())){
//            DemoClass.location.add("Location "+holder.loc.getText().toString() );
//        }
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(holder.loc.getText())){
                    holder.loc.setError("Give Location");
                }

                else {
                    DemoClass.location.add(holder.loc.getText().toString());
                    holder.itemView.setVisibility(View.GONE);


                    models.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, models.size());


                    Toast.makeText(context, "Location Added Succesfully", Toast.LENGTH_SHORT).show();
                }
            }
        });



        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position != -1 && position < models.size()) {
                    models.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, models.size());
                }


//               DemoClass.location.remove(position);
//                notifyItemRangeChanged(position, DemoClass.location.size());

//                notifyDataSetChanged();

            }
        });

    }
    @Override
    public int getItemCount() {
        return models.size();
    }
    public class RvViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        EditText loc;
        FloatingActionButton llItem,add;
        public RvViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.text_loc);
            loc = itemView.findViewById(R.id.locationtext);
            llItem = itemView.findViewById(R.id.delete);
            add = itemView.findViewById(R.id.adding);

        }
    }
}