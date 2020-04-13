package com.practiceandroid.waterbird.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.practiceandroid.waterbird.R;
import com.practiceandroid.waterbird.TripFragment.TripListFragment;

public class TripHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Your Trips");
        FragmentTransaction ft;
        TripListFragment fragmentHome = new TripListFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frameLayoutTrip, fragmentHome).commit();
    }
}
