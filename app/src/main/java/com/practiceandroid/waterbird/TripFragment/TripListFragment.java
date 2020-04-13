package com.practiceandroid.waterbird.TripFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Adapters.TripAdapter;
import com.practiceandroid.waterbird.Classes.TripDetail;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;


public class TripListFragment extends Fragment {

    private RecyclerView recyclerView;
    private TripAdapter tripAdapter;
    private ArrayList<TripDetail> list;
    private LinearLayoutManager layoutManager;
    private FragmentManager fragmentManager;
    private View view;
    public TripListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_trip_list, container, false);
        recyclerView=view.findViewById(R.id.recyclerviewTrip);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        fragmentManager=getFragmentManager();
        list=new ArrayList<>();
        list.add(new TripDetail("4/10/2020 10:10 AM","Water Bird","Completed"));
        list.add(new TripDetail("4/10/2020 10:10 AM","Water Bird","Completed"));
        list.add(new TripDetail("4/10/2020 10:10 AM","Water Bird","Completed"));
        list.add(new TripDetail("4/10/2020 10:10 AM","Water Bird","Completed"));
        list.add(new TripDetail("4/10/2020 10:10 AM","Water Bird","Completed"));
        list.add(new TripDetail("4/10/2020 10:10 AM","Water Bird","Completed"));
        list.add(new TripDetail("4/10/2020 10:10 AM","Water Bird","Completed"));
        list.add(new TripDetail("4/10/2020 10:10 AM","Water Bird","Completed"));
        tripAdapter=new TripAdapter(list,getContext(),fragmentManager);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(tripAdapter);
        return view;
    }
}
