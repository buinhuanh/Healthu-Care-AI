package com.example.healthycareai.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.healthycareai.Adapter.AlarmAdapter;
import com.example.healthycareai.Model.AlarmModel;
import com.example.healthycareai.R;
import com.example.healthycareai.databinding.ActivityShowAlarmBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowAlarmActivity extends AppCompatActivity {
    ActivityShowAlarmBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityShowAlarmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<AlarmModel> sampleAlarms = new ArrayList<>();
        sampleAlarms.add(new AlarmModel(17, 45, Arrays.asList(2,3,4,6,7,1), true));
        sampleAlarms.add(new AlarmModel(17, 5, Arrays.asList(2,3,4,5,6,7,1), true));
        sampleAlarms.add(new AlarmModel(18, 5, Arrays.asList(3,5,6), true));
        sampleAlarms.add(new AlarmModel(18, 5, Arrays.asList(2), true));
        sampleAlarms.add(new AlarmModel(21, 15, Arrays.asList(2,3,4,5,6,7,1), true));


        AlarmAdapter alarmAdapter = new AlarmAdapter(sampleAlarms);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(alarmAdapter);
    }
}