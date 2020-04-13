package com.practiceandroid.waterbird.TestFragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Activities.HomeActivity;
import com.practiceandroid.waterbird.Adapters.ChemicalUsedAdapter;
import com.practiceandroid.waterbird.Classes.ChemicalUsed;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class ChemicalUsedFragment extends Fragment {

    private EditText name,pdos,rdos,stock;
    private Button add;
    private View view;
    private RecyclerView recyclerView;
    private ChemicalUsedAdapter chemicalUsedAdapter;
    private ArrayList<ChemicalUsed> list;
    private String pname,pdose,rdose,stocke;


    public ChemicalUsedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_chemical_used, container, false);
        // custom dialog
        SeekBar seekBar=view.findViewById(R.id.seekbar);
        name=view.findViewById(R.id.pname);
        pdos=view.findViewById(R.id.pdosage);
        rdos=view.findViewById(R.id.rdosage);
        stock=view.findViewById(R.id.stock);
        add=view.findViewById(R.id.addcu);

        pname=name.getText().toString();
        pdose=pdos.getText().toString();
        rdose=rdos.getText().toString();
        stocke=stock.getText().toString();

        recyclerView=view.findViewById(R.id.recyclerrViewChemicalUsed);
        list=new ArrayList<>();

        chemicalUsedAdapter = new ChemicalUsedAdapter(getContext(),list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chemicalUsedAdapter);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    list.add(new ChemicalUsed(name.getText().toString(),
                            pdos.getText().toString(),
                            rdos.getText().toString(),
                            stock.getText().toString()));
                    chemicalUsedAdapter.notifyDataSetChanged();

            }
        });




        seekBar.setEnabled(false);


        view.findViewById(R.id.next5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final Dialog dialog = new Dialog(getContext());
//                dialog.setContentView(R.layout.save_submit);
//                dialog.show();

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.save_submit, null);
                dialogBuilder.setView(dialogView);


                AlertDialog alertDialog = dialogBuilder.create();
                Button save,submit;
                save=dialogView.findViewById(R.id.save);
                submit=dialogView.findViewById(R.id.submitBtn);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(getContext(), HomeActivity.class));
                    }
                });
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(getContext(), HomeActivity.class));
                    }
                });


                alertDialog.show();
            }
        });

        view.findViewById(R.id.backCU).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft;

                TestSampleFragment fragmentContacts = new TestSampleFragment();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayoutTest, fragmentContacts).addToBackStack(null).commit();
            }
        });
        return view;
    }
}
