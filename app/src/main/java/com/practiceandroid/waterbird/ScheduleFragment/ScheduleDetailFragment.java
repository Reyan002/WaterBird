package com.practiceandroid.waterbird.ScheduleFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.practiceandroid.waterbird.R;

import java.util.ArrayList;


public class ScheduleDetailFragment extends Fragment {

    private View view;
    private Spinner spinner;
    private ArrayList<String> list;
    public ScheduleDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_schedule_detail, container, false);

        spinner=view.findViewById(R.id.status);
        list=new ArrayList<>();
        list.add("Pending");
        list.add("Cancel");
        list.add("Reschedule");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);




        return view;
    }
}
