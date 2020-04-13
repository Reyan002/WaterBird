package com.practiceandroid.waterbird.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Activities.TestActivity;
import com.practiceandroid.waterbird.Classes.History;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ScheduleListVH> implements Filterable {

    private ArrayList<History> list;
    private ArrayList<History> filteredList ;
    private FragmentManager f_manager ;
    private Context context;

    public void setScheduleList(final ArrayList<History> list, Context context ) {
        this.context = context;

//        Toast.makeText(context, String.valueOf(list.size()), Toast.LENGTH_SHORT).show();
        if (this.list==null) {
            this.list=list;
            this.filteredList = list;
            notifyItemChanged(0, filteredList.size());
        }
        else{
            Toast.makeText(context, String.valueOf(filteredList.size()), Toast.LENGTH_SHORT).show();
            final DiffUtil.DiffResult result= DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return HistoryAdapter.this.list.size();
                }

                @Override
                public int getNewListSize() {
                    return list.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return HistoryAdapter.this.list.get(oldItemPosition).getReportId() == list.get(newItemPosition).getReportId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    History newMovie = HistoryAdapter.this.list.get(oldItemPosition);

                    History oldMovie = list.get(newItemPosition);

                    return newMovie.getReportId() == oldMovie.getReportId() ;
                }
            });
            this.list = list;
            this.filteredList = list;
            result.dispatchUpdatesTo(this);
        }
//        this.f_manager=f_manager;
    }

    @NonNull
    @Override
    public ScheduleListVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scheduleitem, parent, false);

        return new ScheduleListVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleListVH holder, int position) {
        History schedule=filteredList.get(position);
        holder.reportId.setText(schedule.getReportId());
        holder.clientName.setText(schedule.getClientName());
        holder.date.setText(schedule.getDate());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                View view=LayoutInflater.from(v.getContext()).inflate(R.layout.scheduledetail,null);

                builder.setView(view);
                final AlertDialog alertDialog=builder.create();
                Spinner spinner=view.findViewById(R.id.status);
                Button buttx=view.findViewById(R.id.testSch);
                buttx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.getContext().startActivity(new Intent(v.getContext(), TestActivity.class));
                    }
                });
                ArrayList<String> list=new ArrayList<>();

                list.add("Pending");
                list.add("Cancel");
                list.add("Reschedule");
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);


                alertDialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        if(list != null){
            return filteredList.size();
        } else {
            return 0;
        }
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredList = list;
                } else {
                    ArrayList<History> filteredListin = new ArrayList<>();
                    for (History schedule : list) {
                        if (schedule.getReportId().toLowerCase().contains(charString.toLowerCase())) {
                            filteredListin.add(schedule);
                        }
                    }
                    filteredList = filteredListin;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredList = (ArrayList<History>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }

    public static class ScheduleListVH extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView reportId,clientName,date;



        public ScheduleListVH(@NonNull View itemView) {
            super(itemView);
            reportId=itemView.findViewById(R.id.reportId);
            clientName=itemView.findViewById(R.id.clientName);
            date=itemView.findViewById(R.id.date);

        }
    }
}

