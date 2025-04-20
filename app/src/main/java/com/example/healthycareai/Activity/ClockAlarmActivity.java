package com.example.healthycareai.Activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.healthycareai.R;
import com.example.healthycareai.databinding.ActivityClockAlarmBinding;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ClockAlarmActivity extends AppCompatActivity {

    ActivityClockAlarmBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding=ActivityClockAlarmBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            if (!alarmManager.canScheduleExactAlarms()) {
                Toast.makeText(this, "Ứng dụng cần quyền để đặt báo thức chính xác", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM);
                startActivity(intent);
            }
        }
        setupDayToggle(binding.toggleMon);
        setupDayToggle(binding.toggleTue);
        setupDayToggle(binding.toggleWed);
        setupDayToggle(binding.toggleThu);
        setupDayToggle(binding.toggleFri);
        setupDayToggle(binding.toggleSat);
        setupDayToggle(binding.toggleSun);
      binding.timePicker.setIs24HourView(true);
      binding.btnSetAlarm.setOnClickListener(v ->setAlarm());


    }
    private void setupDayToggle(MaterialButton button) {
        button.setOnClickListener(v -> {
            if (button.isChecked()) {
                button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black)); // màu nền khi chọn
                button.setTextColor(ContextCompat.getColor(this, android.R.color.white));
            } else {
                button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.white)); // màu nền khi bỏ chọn
                button.setTextColor(ContextCompat.getColor(this, R.color.black));
            }
        });
    }

    private void setAlarm() {
        List<Integer> repeatDays = new ArrayList<>();
        if (binding.toggleSun.isChecked()) repeatDays.add(Calendar.SUNDAY);
        if (binding.toggleMon.isChecked()) repeatDays.add(Calendar.MONDAY);
        if (binding.toggleTue.isChecked()) repeatDays.add(Calendar.TUESDAY);
        if (binding.toggleWed.isChecked()) repeatDays.add(Calendar.WEDNESDAY);
        if (binding.toggleThu.isChecked()) repeatDays.add(Calendar.THURSDAY);
        if (binding.toggleFri.isChecked()) repeatDays.add(Calendar.FRIDAY);
        if (binding.toggleSat.isChecked()) repeatDays.add(Calendar.SATURDAY);

        if (repeatDays.isEmpty()) {
            Toast.makeText(this, "Vui lòng chọn ít nhất một ngày để lặp lại", Toast.LENGTH_SHORT).show();
            return;
        }
        for (int day: repeatDays){
            Calendar mCalendar = Calendar.getInstance();
            mCalendar.set(Calendar.HOUR_OF_DAY,binding.timePicker.getHour());
            mCalendar.set(Calendar.MINUTE,binding.timePicker.getMinute());
            mCalendar.set(Calendar.SECOND,0);

           while (mCalendar.get(Calendar.DAY_OF_WEEK)!=day|| mCalendar.before(Calendar.getInstance())){
               mCalendar.add(Calendar.DATE,1);
           }
           int requestCode =day;
            Intent intent = new Intent(this, AlarmReceiver.class);
            PendingIntent mPendingIntent =PendingIntent.getBroadcast(this,requestCode,intent,PendingIntent.FLAG_IMMUTABLE);
            AlarmManager mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP,mCalendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY * 7,mPendingIntent);
            Toast.makeText(this, "Đã đặt báo thức lúc " +
                    binding.timePicker.getHour() + ":" +
                    String.format("%02d", binding.timePicker.getMinute()), Toast.LENGTH_SHORT).show();
        }


    }

}