package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DatePickerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        DatePicker dp = findViewById(R.id.datePicker);
        Button btn = findViewById(R.id.btnGetDate);

        btn.setOnClickListener(v -> {
            int day = dp.getDayOfMonth();
            int month = dp.getMonth() + 1;
            int year = dp.getYear();
            Toast.makeText(this, "Selected date: " + day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
        });
    }
}
