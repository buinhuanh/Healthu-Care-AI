package com.example.healthycareai.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthycareai.Model.AlarmModel;
import com.example.healthycareai.R;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> {
    private List<AlarmModel> alarms;

    public AlarmAdapter(List<AlarmModel> mAlarms) {
        alarms = mAlarms;
    }

    @NonNull
    @Override
    public AlarmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm, parent, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AlarmAdapter.ViewHolder holder, int position) {
        AlarmModel item = alarms.get(position);
        holder.tvTime.setText(String.format(Locale.getDefault(), "%02d:%02d", item.hour, item.minute));
        if (item.repeatDays.size()==7){
            holder.tvRepeatDays.setText("Các ngày trong tuần");
        }
        else {
            StringBuilder days =new StringBuilder();
            for (int day :item.repeatDays){
                days.append("T").append(day== Calendar.SUNDAY ?"CN":(day==Calendar.SATURDAY?"7":(day-1))).append(" ");

            }
            holder.tvRepeatDays.setText(days.toString().trim());
        }
        holder.switchEnable.setChecked(item.isEnabled);

    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTime, tvRepeatDays;
        Switch switchEnable;

         public ViewHolder(@NonNull View itemView) {
            super(itemView);
              tvTime = itemView.findViewById(R.id.tvTime);
              tvRepeatDays = itemView.findViewById(R.id.tvRepeatDays);
              switchEnable =itemView.findViewById(R.id.switchEnable);
        }
    }
}
