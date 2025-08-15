package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int layoutIndex = 0;
    private int[] layouts = {
            R.layout.activity_linear,
            R.layout.activity_relative,
            R.layout.activity_constraint,
            R.layout.activity_frame,
            R.layout.activity_table,
            R.layout.activity_grid
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(layoutIndex);
    }

    private void setLayout(int index) {
        setContentView(layouts[index]);

        // Example: Add a button to switch to next layout, if available in each layout
        // Make sure each layout file includes a Button with the ID: next_layout_btn
        Button nextBtn = findViewById(R.id.next_layout_btn);
        if (nextBtn != null) {
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutIndex = (layoutIndex + 1) % layouts.length;
                    setLayout(layoutIndex);
                }
            });
        }
    }
}
