package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    Button btnInsert, btnView;
    TextView tvResult;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        tvResult = findViewById(R.id.tvResult);

        dbHelper = new DBHelper(this);

        // Insert data
        btnInsert.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String ageStr = etAge.getText().toString();

            if (name.isEmpty() || ageStr.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            int age = Integer.parseInt(ageStr);
            boolean inserted = dbHelper.insertData(name, age);

            if (inserted)
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Insertion failed", Toast.LENGTH_SHORT).show();
        });

        // View all data
        btnView.setOnClickListener(v -> {
            Cursor cursor = dbHelper.getAllData();
            if (cursor.getCount() == 0) {
                tvResult.setText("No records found");
                return;
            }

            StringBuilder sb = new StringBuilder();
            while (cursor.moveToNext()) {
                sb.append("ID: ").append(cursor.getInt(0)).append("\n");
                sb.append("Name: ").append(cursor.getString(1)).append("\n");
                sb.append("Age: ").append(cursor.getInt(2)).append("\n\n");
            }
            tvResult.setText(sb.toString());
        });
    }
}