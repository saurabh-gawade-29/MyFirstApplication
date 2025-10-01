package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button backButton = findViewById(R.id.buttonBack);
        backButton.setOnClickListener(v -> {
            finish(); // Returns to FirstActivity
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Optional: Handling lifecycle if needed
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
