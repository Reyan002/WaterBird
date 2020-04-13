package com.practiceandroid.waterbird.TestFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class ProjectFragment extends Fragment {

    private ArrayList<String> items=new ArrayList<>();
    private SpinnerDialog spinnerDialog;


    private View view;
    public ProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_project, container, false);
         SeekBar seekBar=view.findViewById(R.id.seekbar);
//        final TextView selectedItems=(TextView)findViewById(R.id.txt);//

        final LinearLayout ll=view.findViewById(R.id.ll);

        items.add("DUBAI HARBOUR CRUISE TERMINAL");
        items.add("B+G+4+R Floors Hotel Building At Miracle Garden");
        items.add("Marafeq General Service");
        items.add("Geepas Residential Building @Al Barsha Dubau, UAE");
        items.add("Remco - Babel Tower");
        items.add("Site Technology - DEWA Data Hub (Moro)");
        items.add("Birds Electromechanical");
        items.add("Fujairah Business Centre");
        items.add("DEWA Staff Accomodation At Jabel Ali");
        items.add("Midtown Afnan By Deyaar");
        items.add("Abu Dhabi Future School - Al Ain");
        items.add("RADISSON BLUE, FUJAIRAH");


        spinnerDialog=new SpinnerDialog(getActivity(),items,"Select Project","Close");// With No Animation
        //spinnerDialog=new SpinnerDialog(getActivity(),items,"Select or Search City",R.style.DialogAnimations_SmileWindow,"Close Button Text");// With 	Animation

        spinnerDialog.setCancellable(true); // for cancellable
        spinnerDialog.setShowKeyboard(false);// for open keyboard by default


        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(getContext(), item + "  " + position+"", Toast.LENGTH_SHORT).show();

                ll.setVisibility(View.VISIBLE);
//                selectedItems.setText(item + " Position: " + position);
            }
        });
       view. findViewById(R.id.project_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDialog.showSpinerDialog();
            }
        });




        seekBar.setEnabled(false);
        view.findViewById(R.id.next2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft;

                LocationFragment fragmentContacts = new LocationFragment();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayoutTest, fragmentContacts).addToBackStack(null).commit();
            }
        });
        view.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft;

                DateAndTimeFragment fragmentContacts = new DateAndTimeFragment();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayoutTest, fragmentContacts).addToBackStack(null).commit();
            }
        });
        return view;
    }

}
