package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.ToggleButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ToggleButtonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_togglebutton);

        ToggleButton toggle = findViewById(R.id.toggleBtn);
        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this, "Toggle is " + (isChecked ? "ON" : "OFF"), Toast.LENGTH_SHORT).show();
        });
    }
}
