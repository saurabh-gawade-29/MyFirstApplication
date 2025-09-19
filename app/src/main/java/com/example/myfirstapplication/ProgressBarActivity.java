package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressBarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        Button btn = findViewById(R.id.btnIncrease);

        btn.setOnClickListener(v -> {
            int p = progressBar.getProgress();
            p += 10;
            if (p > progressBar.getMax()) p = progressBar.getMax();
            progressBar.setProgress(p);
        });
    }
}
