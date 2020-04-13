package com.practiceandroid.waterbird.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.material.textfield.TextInputEditText;
import com.practiceandroid.waterbird.Fragments.SignIn;
import com.practiceandroid.waterbird.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FragmentTransaction ft;
        SignIn fragmentHome = new SignIn();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frameLayout, fragmentHome).commit();

    }




}

