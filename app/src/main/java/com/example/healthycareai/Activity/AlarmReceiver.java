package com.example.healthycareai.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import com.example.healthycareai.R;

public class AlarmReceiver extends BroadcastReceiver {
   @Override
   public void onReceive(Context context, Intent intent) {
      Log.d("AlarmReceiver", "onReceive called");  // Thêm log để kiểm tra

      MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.alarm_sound);
      mediaPlayer.start();

      Toast.makeText(context, "Báo thức reo!", Toast.LENGTH_LONG).show();
   }
}
