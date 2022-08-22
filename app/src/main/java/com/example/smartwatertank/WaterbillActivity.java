package com.example.smartwatertank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smartwatertank.databinding.ActivityWaterbillBinding;

public class WaterbillActivity extends DrawerBaseActivity {
    ActivityWaterbillBinding activityWaterbillBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityWaterbillBinding = ActivityWaterbillBinding.inflate(getLayoutInflater());
        setContentView(activityWaterbillBinding.getRoot());
        allocateActivityTitle("Waterbill");
    }
}