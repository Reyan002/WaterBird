package com.practiceandroid.waterbird.ScheduleFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Adapters.SchduleAdapter;
import com.practiceandroid.waterbird.Classes.Schedule;

import java.util.ArrayList;


public class ScheduleListFragment extends Fragment {

    private View view;
    private ArrayList<Schedule> list;
    private RecyclerView recyclerView;
    private SchduleAdapter adapter;
    private LinearLayoutManager layoutManager;
    public ScheduleListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


//        view=  inflater.inflate(R.layout.fragment_schedule_list, container, false);
//        recyclerView=view.findViewById(R.id.scheduleRecyclerview);
//        list=new ArrayList<>();
//
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
//
//
//        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//
//        FragmentManager fragment_schedule_list=getFragmentManager();
//        adapter=new SchduleAdapter(list,getContext(),fragment_schedule_list);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

        return view;
    }


}
