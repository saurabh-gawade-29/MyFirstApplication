package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button btn = findViewById(R.id.btnAction);
        btn.setOnClickListener(v -> Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show());
    }
}
