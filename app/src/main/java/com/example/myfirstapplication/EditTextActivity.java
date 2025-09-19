package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditTextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        EditText edt = findViewById(R.id.edtName);
        Button btn = findViewById(R.id.btnShow);
        TextView txt = findViewById(R.id.txtResult);

        btn.setOnClickListener(v -> {
            String name = edt.getText().toString();
            if(name.isEmpty()) {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
            } else {
                txt.setText("Hello " + name);
            }
        });
    }
}
