package com.practiceandroid.waterbird.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.practiceandroid.waterbird.R;
import com.practiceandroid.waterbird.TestTripFragments.TimerFragment;

public class StartJourneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_journey);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Plan A Trip");


        FragmentTransaction ft;
        TimerFragment fragmentHome = new TimerFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frameLayoutJourney, fragmentHome).commit();

    }



}
