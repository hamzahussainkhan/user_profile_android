package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class userprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}