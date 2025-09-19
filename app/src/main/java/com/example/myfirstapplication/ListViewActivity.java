package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = findViewById(R.id.listView);
        String[] data = new String[] {"Apple","Banana","Cherry","Date","Elderberry","Fig","Grape"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) ->
            Toast.makeText(this, "Clicked: " + data[position], Toast.LENGTH_SHORT).show()
        );
    }
}
