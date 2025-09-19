package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckBoxActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        CheckBox chkA = findViewById(R.id.chkA);
        CheckBox chkB = findViewById(R.id.chkB);
        Button btn = findViewById(R.id.btnCheck);

        btn.setOnClickListener(v -> {
            StringBuilder sb = new StringBuilder("Selected: ");
            if (chkA.isChecked()) sb.append("A ");
            if (chkB.isChecked()) sb.append("B ");
            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
        });
    }
}
