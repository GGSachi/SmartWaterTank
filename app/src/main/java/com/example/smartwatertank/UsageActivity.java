package com.example.smartwatertank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smartwatertank.databinding.ActivityDashboardBinding;
import com.example.smartwatertank.databinding.ActivityUsageBinding;

public class UsageActivity extends DrawerBaseActivity {

    ActivityUsageBinding activityUsageBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUsageBinding = ActivityUsageBinding.inflate(getLayoutInflater());
        setContentView(activityUsageBinding.getRoot());
        allocateActivityTitle("Usage");
    }
}