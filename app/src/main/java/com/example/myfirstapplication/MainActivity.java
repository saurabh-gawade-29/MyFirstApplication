package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextField, editTextArea;
    RadioGroup radioGroup;
    Spinner spinnerCountry;
    CheckBox checkSubscribe;
    ImageButton imageButton;
    Button buttonSubmit;
    String selectedImageButton = "Not pressed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextField = findViewById(R.id.editTextField);
        editTextArea = findViewById(R.id.editTextArea);
        radioGroup = findViewById(R.id.radioGroup);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        checkSubscribe = findViewById(R.id.checkSubscribe);
        imageButton = findViewById(R.id.imageButton);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        String[] countries = {"India", "USA", "UK"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, countries);
        spinnerCountry.setAdapter(adapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageButton = "Camera Image Button was pressed";
                Toast.makeText(MainActivity.this, "ImageButton pressed", Toast.LENGTH_SHORT).show();
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textField = editTextField.getText().toString();
                String textArea = editTextArea.getText().toString();

                int selectedRadioId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioId);
                String gender = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "None";

                String country = spinnerCountry.getSelectedItem().toString();
                String subscribe = checkSubscribe.isChecked() ? "Yes" : "No";

                String message = "Text Field: " + textField +
                        "\nText Area: " + textArea +
                        "\nGender: " + gender +
                        "\nCountry: " + country +
                        "\nSubscribed: " + subscribe +
                        "\nImageButton status: " + selectedImageButton;

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Form Details")
                        .setMessage(message)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}

