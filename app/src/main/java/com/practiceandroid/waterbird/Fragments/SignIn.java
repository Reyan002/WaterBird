package com.practiceandroid.waterbird.Fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;
import com.practiceandroid.waterbird.Activities.HomeActivity;
import com.practiceandroid.waterbird.Classes.DemoClass;
import com.practiceandroid.waterbird.R;

public class SignIn extends Fragment {
    private TextView forget;
    private VideoView videoView;
    private Button login;
    private TextInputEditText username,password;
    private ProgressBar progressBar;
    public SignIn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_in, container, false);
        videoView = view.findViewById(R.id.vedio);
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.splash;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });

//        MediaController mediaController = new MediaController(this);
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);

        login=view.findViewById(R.id.btnSignin);
        username=view.findViewById(R.id.username_edit_text);
        password=view.findViewById(R.id.password_edit_text);
        forget=view.findViewById(R.id.forget);
//        progressBar=view.findViewById(R.id.four);
        Animation animationa= AnimationUtils.loadAnimation(getContext(),R.anim.slide_in_right);
        Animation animationb= AnimationUtils.loadAnimation(getContext(),R.anim.slide_out_left);

        login.setAnimation(animationa);
        username.setAnimation(animationa);
        password.setAnimation(animationa);
        forget.setAnimation(animationa);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ProgressDialog progressDialog;

                //  progressDialog = new ProgressDialog(LoginActivity.this);


               // progressBar.setVisibility(View.VISIBLE);

//                progressDialog.setMessage("Please Wait...");
                //progressDialog.show();
                 startActivity(new Intent(getContext(), HomeActivity.class));
                DemoClass.check=true;
//                progressDialog.dismiss();
            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft;

                ForgetPassword fragmentContacts = new ForgetPassword();
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, fragmentContacts).addToBackStack(null).commit();
            }
        });
        getActivity().overridePendingTransition(0,0);
        View relativeLayout=view.findViewById(R.id.login_container);
        Animation animation= AnimationUtils.loadAnimation(getContext(),android.R.anim.fade_in);
        relativeLayout.startAnimation(animation);
        return view;
    }
    @Override
    public void onResume() {
        videoView.start();
        super.onResume();
    }

    @Override
    public void onPause() {
        videoView.stopPlayback();
        super.onPause();
    }
}
