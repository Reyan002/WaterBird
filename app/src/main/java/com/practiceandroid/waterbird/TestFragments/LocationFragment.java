package com.practiceandroid.waterbird.TestFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.practiceandroid.waterbird.Adapters.RvAdapter;
import com.practiceandroid.waterbird.Classes.LocationItems;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class LocationFragment extends Fragment {

    ArrayList<LocationItems> models = new ArrayList<>();
    RecyclerView rvTechSolPoint;
    RvAdapter rvAdapter;
    private int count=2;
    private View view;
    private FloatingActionButton tvAdd;
    public LocationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_location, container, false);

        rvTechSolPoint = view.findViewById(R.id.recylclerviewlocation);
        tvAdd=view.findViewById(R.id.add);


        rvTechSolPoint.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvTechSolPoint.setLayoutManager(layoutManager);
        rvAdapter = new RvAdapter(getContext(), models  );
        rvTechSolPoint.setAdapter(rvAdapter);
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                models.add(new LocationItems());
                count++;
                rvAdapter.notifyDataSetChanged();
            }
        });
//         for (int i=0;i<models.size();i++){
//             View view=rvTechSolPoint.getChildAt(i);
//             EditText editText=view.findViewById(R.id.locationtext);
//             String text=editText.getText().toString();
//             DemoClass.location.add(text);
//         }

        SeekBar seekBar=view.findViewById(R.id.seekbar);
        seekBar.setEnabled(false);
        view.findViewById(R.id.next3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft;

                TestSampleFragment fragmentContacts = new TestSampleFragment();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayoutTest, fragmentContacts).addToBackStack(null).commit();
             }
        });
        view.findViewById(R.id.backLoc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft;

                ProjectFragment fragmentContacts = new ProjectFragment();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayoutTest, fragmentContacts).addToBackStack(null).commit();
            }
        });
        return view;
    }

}
