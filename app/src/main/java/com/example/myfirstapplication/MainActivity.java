package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnAnimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnAnimate = findViewById(R.id.btnAnimate);

        // Load animation from XML
        Animation moveAnim = AnimationUtils.loadAnimation(this, R.anim.move);

        btnAnimate.setOnClickListener(v -> {
            imageView.startAnimation(moveAnim);
        });
    }
}