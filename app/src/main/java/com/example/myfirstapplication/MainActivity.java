package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int layoutIndex = 0;
    private int[] layouts = {
            R.layout.activity_linear,
            R.layout.activity_relative,
            R.layout.activity_constraint,
            R.layout.activity_frame,
            R.layout.activity_table,
            R.layout.activity_grid,
            R.layout.activity_absolute,
            R.layout.activity_list
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(layoutIndex);
    }

    private void setLayout(int index) {
        setContentView(layouts[index]);

        // Next Layout Button
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

        // Setup ListView ONLY if activity_list is active
        if (layouts[index] == R.layout.activity_list) {
            String[] array = { "Linear", "Relative", "Constraint", "Frame", "Table", "Grid", "Absolute" };
            ListView listView = findViewById(R.id.simpleListView);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
            listView.setAdapter(adapter);
        }
    }
}
