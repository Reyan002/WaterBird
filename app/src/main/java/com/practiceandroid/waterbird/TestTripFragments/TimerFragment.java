package com.practiceandroid.waterbird.TestTripFragments;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.practiceandroid.waterbird.R;


public class TimerFragment extends Fragment {
    int minute;
    long min;
   private TextView tv_timer;


    private View view;
    public TimerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_blank, container, false);
//        tv_timer=view.findViewById(R.id.timer);
////        minute=Integer.parseInt("Your time in string form like 10");//
//        min= 2*60*1000;
//        counter(min);
        Chronometer simpleChronometer = (Chronometer)view. findViewById(R.id.simpleChronometer); // initiate a chronometer
        Button reached=view.findViewById(R.id.reached);



        simpleChronometer.start();
        reached.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleChronometer.stop();
                Toast.makeText(getContext(), simpleChronometer.getText().toString(), Toast.LENGTH_SHORT).show();
                FragmentTransaction ft;

                ArrivalLocationFragment fragmentContacts = new ArrivalLocationFragment();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayoutJourney, fragmentContacts).addToBackStack(null).commit();
            }
        });

        return view;
    }

    private void counter(long min) {
        CountDownTimer timer = new CountDownTimer(min, 1000) {
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
                int hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                tv_timer.setText(String.format("%d:%d:%d", hours, minutes, seconds));
            }
            public void onFinish() {
                Toast.makeText(getContext(), "Your time has been completed",
                        Toast.LENGTH_LONG).show();
            }
        };
        timer.start();
    }


}
