package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RadioButtonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);

        RadioGroup group = findViewById(R.id.radioGroup);
        Button checkBtn = findViewById(R.id.btnCheckRadio);

        checkBtn.setOnClickListener(v -> {
            int selectedId = group.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selected = findViewById(selectedId);
                Toast.makeText(this, "Selected: " + selected.getText(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No selection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
