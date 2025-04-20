package com.example.healthycareai.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.healthycareai.Model.AlarmModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class AlarmStorage {
   private static final String PREF_NAME = "alarm_prefs";
   private static final String KEY_ALARM = "alarms";

   public static void saveAlarm(Context mContext , List<AlarmModel> aLarms){
        SharedPreferences prefs = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(aLarms);
        mEditor.putString(PREF_NAME,json);
        mEditor.apply();
     }
     public static List<AlarmModel> loadAlarms(Context mContext){
      SharedPreferences mSharedPreferences =mContext.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
      String json = mSharedPreferences.getString(KEY_ALARM, null);
      if (json==null) return new ArrayList<>();
      Gson gson = new Gson();
        Type type = new TypeToken<List<AlarmModel>>() {}.getType();
        return gson.fromJson(json, type);
     }
}
