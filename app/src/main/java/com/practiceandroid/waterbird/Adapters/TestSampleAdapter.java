package com.practiceandroid.waterbird.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Classes.Test;
import com.practiceandroid.waterbird.Classes.TestSample;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class TestSampleAdapter extends RecyclerView.Adapter<TestSampleAdapter.TestSampleVH>{
    private View view;
    private Context context;
    private ArrayList<TestSample> list;

    public TestSampleAdapter(Context context, ArrayList<TestSample> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TestSampleVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.test_sample_item, parent, false);
        TestSampleVH rvViewHolder = new TestSampleVH(view);
        return rvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TestSampleVH holder, final int position) {

        TestSample testSample=list.get(position);
        if (testSample.getTestName() != null) {
            holder.itemName.setText(testSample.getTestName());


        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position != -1 && position < list.size()) {
                    list.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, list.size());
                }

            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                View view=LayoutInflater.from(context).inflate(R.layout.testsampledialog,null);

                builder.setView(view);

                ArrayList<Test> tests=new ArrayList<>();
                tests.add(new Test("pH","8.50-11.00",""));
                tests.add(new Test("Conductivity","<3000",""));
                tests.add(new Test("Total Dissolved Solid","<2100",""));
                tests.add(new Test("Nitrite","<700",""));
                tests.add(new Test("Suspended Solids","<30.0",""));
                tests.add(new Test("Dissolved Iron","<0.50",""));
                tests.add(new Test("pH","8.50-11.00",""));
                tests.add(new Test("Conductivity","<3000",""));
                tests.add(new Test("Total Dissolved Solid","<2100",""));
                tests.add(new Test("Nitrite","<700",""));
                tests.add(new Test("Suspended Solids","<30.0",""));
                tests.add(new Test("Dissolved Iron","<0.50",""));
                RecyclerView recyclerView=view.findViewById(R.id.recylclerviewtest);
                TestAdapter testAdapter=new TestAdapter(v.getContext(),tests);
                LinearLayoutManager layoutManager = new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false);

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(testAdapter);

                testAdapter.notifyDataSetChanged();

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       holder.itemView.setBackgroundResource(R.color.colorPrimary);
                       dialog.dismiss();
                    }
                });
                final AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TestSampleVH extends RecyclerView.ViewHolder {
        TextView itemName;
         ImageView imageView;
        public TestSampleVH(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.test_name);
            imageView = itemView.findViewById(R.id.test_delete);


        }
    }
}
