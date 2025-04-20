package com.example.healthycareai.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.healthycareai.R;
import com.example.healthycareai.databinding.ActivitySleepBinding;

public class SleepActivity extends AppCompatActivity {
    ActivitySleepBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySleepBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

     binding.itemAlarmClock.setOnClickListener(view -> {
         Intent intent = new Intent(SleepActivity.this, ShowAlarmActivity.class);
         startActivity(intent);
     });


    }
}