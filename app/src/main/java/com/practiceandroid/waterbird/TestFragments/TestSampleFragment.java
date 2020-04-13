package com.practiceandroid.waterbird.TestFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Adapters.TestSampleAdapter;
import com.practiceandroid.waterbird.Classes.DemoClass;
import com.practiceandroid.waterbird.Classes.TestSample;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class TestSampleFragment extends Fragment {
    private ArrayList<String> items=new ArrayList<>();
    private ArrayList<String> testSample=new ArrayList<>();
    private ArrayList<TestSample> testSampleArrayList=new ArrayList<>();
    private SpinnerDialog spinnerDialog;
    private  View view;
    private RecyclerView recyclerView;
    private TestSampleAdapter testSampleAdapter;
    private TextView test,loc;


    public TestSampleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_test_sample, container, false);
        recyclerView=view.findViewById(R.id.test_sample_recyclerview);
        testSampleAdapter=new TestSampleAdapter(getContext(),testSampleArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(testSampleAdapter);



        SeekBar seekBar=view.findViewById(R.id.seekbar);
        seekBar.setEnabled(false);
        items= DemoClass.location;
        items.add("Location 1");

        loc=view. findViewById(R.id.loc_select) ;
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSpinnerDialogLoc(items,"Select Location");
            }
        });

        for(int i=0;i<10;i++){
            testSample.add("Test "+i);
        }

        test=view. findViewById(R.id.test_sample_select);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSpinnerDialog(testSample,"Select Test Sample");
            }
        });

        view.findViewById(R.id.next4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft;

                ChemicalUsedFragment fragmentContacts = new ChemicalUsedFragment();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayoutTest, fragmentContacts).addToBackStack(null).commit();
            }
        });
        view.findViewById(R.id.backTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft;

                items.clear();
                LocationFragment fragmentContacts = new LocationFragment();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayoutTest, fragmentContacts).addToBackStack(null).commit();
            }
        });
        return view;
    }


    public void showSpinnerDialog(ArrayList<String> list,String name){
        spinnerDialog=new SpinnerDialog(getActivity(),list,name,"Close");// With No Animation
        //spinnerDialog=new SpinnerDialog(getActivity(),items,"Select or Search City",R.style.DialogAnimations_SmileWindow,"Close Button Text");// With 	Animation

        spinnerDialog.setCancellable(true); // for cancellable
        spinnerDialog.setShowKeyboard(false);// for open keyboard by default


        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                //Toast.makeText(getContext(), item + "  " + position+"", Toast.LENGTH_SHORT).show();

                test.setText(item);
                testSampleArrayList.add(new TestSample());
                testSampleAdapter.notifyDataSetChanged();
                // ll.setVisibility(View.VISIBLE);
//                selectedItems.setText(item + " Position: " + position);
            }
        });

        spinnerDialog.showSpinerDialog();

    }

    public void showSpinnerDialogLoc(ArrayList<String> list,String name){
        spinnerDialog=new SpinnerDialog(getActivity(),list,name,"Close");// With No Animation
        //spinnerDialog=new SpinnerDialog(getActivity(),items,"Select or Search City",R.style.DialogAnimations_SmileWindow,"Close Button Text");// With 	Animation

        spinnerDialog.setCancellable(true); // for cancellable
        spinnerDialog.setShowKeyboard(false);// for open keyboard by default


        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(getContext(), item + "  " + position+"", Toast.LENGTH_SHORT).show();
                loc.setText(item);

                test.setVisibility(View.VISIBLE);
                testSampleArrayList.clear();
                testSampleAdapter.notifyDataSetChanged();
//                testSampleArrayList=new ArrayList<>();
//                testSampleAdapter.notifyDataSetChanged();

                 // ll.setVisibility(View.VISIBLE);
//                selectedItems.setText(item + " Position: " + position);
            }
        });

        spinnerDialog.showSpinerDialog();

    }

    public  void RecyclerView(RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager, TestSampleAdapter testSampleAdapter, ArrayList<TestSample> list){
        testSampleAdapter=new TestSampleAdapter(getContext(),list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(testSampleAdapter);

    }
}
