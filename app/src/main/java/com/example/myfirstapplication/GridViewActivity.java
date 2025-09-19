package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GridViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        GridView grid = findViewById(R.id.gridView);
        String[] items = new String[] {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener((parent, view, position, id) ->
            Toast.makeText(this, "Clicked: " + items[position], Toast.LENGTH_SHORT).show()
        );
    }
}
