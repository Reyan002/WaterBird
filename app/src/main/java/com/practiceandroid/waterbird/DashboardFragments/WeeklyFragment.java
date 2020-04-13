package com.practiceandroid.waterbird.DashboardFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.Cartesian;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.Pie;
import com.anychart.anychart.ValueDataEntry;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;
import java.util.List;

public class WeeklyFragment extends Fragment {
    private View view;
    public WeeklyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_weekly, container, false);
        accounts();
        imports();
        exports();
        cf();
        return view;
    }
    public void accounts(){
        AnyChartView anyChartView = view.findViewById(R.id.any_chart_view);
        APIlib.getInstance().setActiveAnyChartView(anyChartView);

        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Pending", 50));
        data.add(new ValueDataEntry("Cancel", 20));
        data.add(new ValueDataEntry("Reschedule", 10));
        data.add(new ValueDataEntry("Completed", 200));
//        data.add(new ValueDataEntry("Expenses", 1200000));?

        pie.data(data);

//        pie.title("Accounting in 2019 (in kg)");

        anyChartView.setChart(pie);
    }
    public void exports(){
        AnyChartView anyChartView1 = view.findViewById(R.id.bar);
        APIlib.getInstance().setActiveAnyChartView(anyChartView1);

        Cartesian pie1 = AnyChart.bar();

        List<DataEntry> data1 = new ArrayList<>();
        data1.add(new ValueDataEntry("Sulfate", 150));
        data1.add(new ValueDataEntry("Total Iron", 320));
        data1.add(new ValueDataEntry("Corrosion Inhibitor (A2312)", 150));
        data1.add(new ValueDataEntry("Phosphate", 300));
        data1.add(new ValueDataEntry("Appearence", 150));
        data1.add(new ValueDataEntry("Bromine", 320));
        data1.add(new ValueDataEntry("Dissolved Iron", 120));
        data1.add(new ValueDataEntry("Appearence", 150));
        data1.add(new ValueDataEntry("Suspended Solids", 300));
        data1.add(new ValueDataEntry("Chlorine", 150));
        data1.add(new ValueDataEntry("Inhibitor", 120));
        data1.add(new ValueDataEntry("Cyanuric Acid", 150));
        data1.add(new ValueDataEntry("Silica", 320));
        data1.add(new ValueDataEntry("Molybdate", 150));
        data1.add(new ValueDataEntry("Nitrite", 300));
        data1.add(new ValueDataEntry("Phosphonate", 120));
        data1.add(new ValueDataEntry("Sulphite", 320));
        data1.add(new ValueDataEntry("Iron", 150));
        data1.add(new ValueDataEntry("Total Dissolved Solids", 200));
        data1.add(new ValueDataEntry("Conductivity", 300));
        data1.add(new ValueDataEntry("pH", 120));

        pie1.data(data1);



        anyChartView1.setChart(pie1);


    }
    public void imports(){
        AnyChartView anyChartView1 = view.findViewById(R.id.imports);
        APIlib.getInstance().setActiveAnyChartView(anyChartView1);

        Cartesian pie1 = AnyChart.column();

        List<DataEntry> data1 = new ArrayList<>();
        data1.add(new ValueDataEntry("Good", 500));
        data1.add(new ValueDataEntry("Excellent", 300));
        data1.add(new ValueDataEntry("Fair", 100));
        data1.add(new ValueDataEntry("Bad", 50));
        data1.add(new ValueDataEntry("Worst", 10));

        pie1.data(data1);


//        pie1.title("Imports in 2019 (in kg)");
        anyChartView1.setChart(pie1);


    }
    public void cf(){
        AnyChartView anyChartView1 = view.findViewById(R.id.cf);
        APIlib.getInstance().setActiveAnyChartView(anyChartView1);

        Cartesian pie1 = AnyChart.line();

        List<DataEntry> data1 = new ArrayList<>();
        data1.add(new ValueDataEntry("January", 1000));
        data1.add(new ValueDataEntry("February", 1500));
        data1.add(new ValueDataEntry("March", 1600));
        data1.add(new ValueDataEntry("April", 1200));
        data1.add(new ValueDataEntry("May", 800));
        data1.add(new ValueDataEntry("June", 900));
        data1.add(new ValueDataEntry("July", 1100));
        data1.add(new ValueDataEntry("August", 1300));
        data1.add(new ValueDataEntry("September", 1400));
        data1.add(new ValueDataEntry("October", 600));
        data1.add(new ValueDataEntry("November", 800));
        data1.add(new ValueDataEntry("December", 1800));


        pie1.data(data1);


//        pie1.title("Live Chat in 2019 (in kg)");
        anyChartView1.setChart(pie1);


    }
}
