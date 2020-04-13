package com.practiceandroid.waterbird.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.practiceandroid.waterbird.Classes.DemoClass;
import com.practiceandroid.waterbird.R;
import com.practiceandroid.waterbird.TestFragments.DateAndTimeFragment;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        FragmentTransaction ft;
        DateAndTimeFragment fragmentHome = new DateAndTimeFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frameLayoutTest, fragmentHome).commit();
        DemoClass.location.clear();
    }
}
