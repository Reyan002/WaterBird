package com.practiceandroid.waterbird.Fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;
import com.practiceandroid.waterbird.R;

public class ForgetPassword extends Fragment {
    private VideoView videoView;
    private Button back,submit;
    private TextView forget;

    private Button login;
    private TextInputEditText username ;
 public ForgetPassword() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_forget_password, container, false);
        Animation animationa= AnimationUtils.loadAnimation(getContext(),R.anim.slide_in_right);

        back=view.findViewById(R.id.back);
        username=view.findViewById(R.id.username_edit_text);
        submit=view.findViewById(R.id.submit);
        videoView = view.findViewById(R.id.vedioa);
        username.setAnimation(animationa);
        submit.setAnimation(animationa);
        back.setAnimation(animationa);
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.splash;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft;

                SignIn fragmentContacts = new SignIn();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, fragmentContacts).addToBackStack(null).commit();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft;

                ResetFragment fragmentContacts = new ResetFragment();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, fragmentContacts).addToBackStack(null).commit();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });
        return view;
    }
    @Override
    public void onPause() {
        videoView.stopPlayback();
        super.onPause();
    }
}
