package com.example.healthycareai.Model;

import java.util.List;

public class AlarmModel {
    public int hour;
    public int minute;
    public List<Integer> repeatDays;
    public boolean isEnabled;

    public AlarmModel(int mHour, int mMinute, List<Integer> mRepeatDays, boolean mIsEnabled) {
        hour = mHour;
        minute = mMinute;
        isEnabled = mIsEnabled;
        repeatDays = mRepeatDays;
    }
}
