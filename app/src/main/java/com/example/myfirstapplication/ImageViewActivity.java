package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ImageViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);

        ImageView iv = findViewById(R.id.imageView);
        iv.setOnClickListener(v -> Toast.makeText(this, "Image clicked", Toast.LENGTH_SHORT).show());
    }
}
