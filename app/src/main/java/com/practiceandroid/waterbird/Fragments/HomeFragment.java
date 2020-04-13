package com.practiceandroid.waterbird.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Adapters.HomeAdapter;
import com.practiceandroid.waterbird.Adapters.SliderAdapterExample;
import com.practiceandroid.waterbird.Classes.HomeItems;
import com.practiceandroid.waterbird.Classes.SliderItem;
import com.practiceandroid.waterbird.R;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
  private RecyclerView recyclerView;
  private HomeAdapter mAdapter;
  private ArrayList<HomeItems> arrayList=new ArrayList<>();
 private SliderView sliderView;
  private List<SliderItem> sliderItems;
  private SliderAdapterExample adapter;

  public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        sliderItems=new ArrayList<>();

        sliderItems.add(new SliderItem("Dashboard","https://www.mankindpharma.com/assets/img/mb-sustainable-quality-culture.jpg"));
        sliderItems.add(new SliderItem("Live Chat","https://www.caut.ca/sites/default/files/styles/responsive_large_constrict/public/women-science-students-studying-chemistry-with-professor-in-laboratory-horizontal-481013203_2122x1415.jpeg?itok=cPzVF4Pn"));
        sliderItems.add(new SliderItem("Chemists","https://wallpaperaccess.com/full/2153804.jpg"));
      sliderItems.add(new SliderItem("Lab Testing","https://innovationexcellence.com/wp-content/uploads/2017/09/medical-research.jpg"));
      sliderItems.add(new SliderItem("Reports","https://generationstudy.com/wp-content/uploads/2020/01/Studying-Medicine-in-Singapore.jpg"));
      sliderItems.add(new SliderItem("Customer Satisfaction","https://static.telegraphindia.com/library/THE_TELEGRAPH/image/2019/4/1d54d767-56fe-4bed-be13-3b160bd00c50.jpg"));
      sliderView = view.findViewById(R.id.imageSlider);

      adapter = new SliderAdapterExample(getContext(),sliderItems);
      sliderView.setSliderAdapter(adapter);

      sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
      sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
      sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
      sliderView.setIndicatorSelectedColor(Color.WHITE);
      sliderView.setIndicatorUnselectedColor(Color.GRAY);
      sliderView.setScrollTimeInSec(3);
        sliderView.startAutoCycle();
//        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

      recyclerView=view.findViewById(R.id.recylclerview);
      mAdapter = new HomeAdapter(arrayList,getContext());
      recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

      recyclerView.setItemAnimator(new DefaultItemAnimator());
      recyclerView.setAdapter(mAdapter);

      prepareMovieData();
        return view;
    }
  private void prepareMovieData() {


    HomeItems accounting = new HomeItems("Dashboard", R.mipmap.dashboardbl,"#ffffff");
    arrayList.add(accounting);

    HomeItems export = new HomeItems("Schedule", R.mipmap.calendarbl,"#ffffff");
    arrayList.add(export);
    HomeItems Imports = new HomeItems("Test", R.mipmap.flaskbl,"#ffffff");
    arrayList.add(Imports);

    HomeItems cf = new HomeItems("Customer Review", R.mipmap.reviewbl,"#ffffff");
    arrayList.add(cf);

    HomeItems trading = new HomeItems("Test History", R.mipmap.clockbl,"#ffffff");
    arrayList.add(trading);

    HomeItems hrms = new HomeItems("Settings", R.mipmap.settingsbl,"#ffffff");
    arrayList.add(hrms);
//      HomeItems live = new HomeItems("Live Chat", R.mipmap.text,"#ffffff");
//      arrayList.add(live);
//    HomeItems logout = new HomeItems("Logout", R.mipmap.logoutbl,"#ffffff");
//    arrayList.add(logout);






    mAdapter.notifyDataSetChanged();
  }

    @Override
    public void onResume() {
        sliderView.startAutoCycle();

        super.onResume();
    }

    @Override
    public void onPause() {
        sliderView.stopAutoCycle();

        super.onPause();
    }
}
