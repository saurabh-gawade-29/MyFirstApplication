package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ImageButtonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagebutton);

        ImageButton imgBtn = findViewById(R.id.imgBtn);
        imgBtn.setOnClickListener(v -> Toast.makeText(this, "ImageButton Clicked", Toast.LENGTH_SHORT).show());
    }
}
