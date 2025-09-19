package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TimePickerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        TimePicker tp = findViewById(R.id.timePicker);
        Button btn = findViewById(R.id.btnGetTime);

        btn.setOnClickListener(v -> {
            int hour = tp.getHour();
            int minute = tp.getMinute();
            Toast.makeText(this, "Selected time: " + hour + ":" + minute, Toast.LENGTH_SHORT).show();
        });
    }
}
