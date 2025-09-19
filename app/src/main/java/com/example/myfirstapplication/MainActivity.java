package com.example.uiexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnTextView).setOnClickListener(v -> startActivity(new Intent(this, TextViewActivity.class)));
        findViewById(R.id.btnEditText).setOnClickListener(v -> startActivity(new Intent(this, EditTextActivity.class)));
        findViewById(R.id.btnButton).setOnClickListener(v -> startActivity(new Intent(this, ButtonActivity.class)));
        findViewById(R.id.btnImageButton).setOnClickListener(v -> startActivity(new Intent(this, ImageButtonActivity.class)));
        findViewById(R.id.btnToggleButton).setOnClickListener(v -> startActivity(new Intent(this, ToggleButtonActivity.class)));
        findViewById(R.id.btnRadio).setOnClickListener(v -> startActivity(new Intent(this, RadioButtonActivity.class)));
        findViewById(R.id.btnCheckBox).setOnClickListener(v -> startActivity(new Intent(this, CheckBoxActivity.class)));
        findViewById(R.id.btnProgress).setOnClickListener(v -> startActivity(new Intent(this, ProgressBarActivity.class)));
        findViewById(R.id.btnList).setOnClickListener(v -> startActivity(new Intent(this, ListViewActivity.class)));
        findViewById(R.id.btnGrid).setOnClickListener(v -> startActivity(new Intent(this, GridViewActivity.class)));
        findViewById(R.id.btnImageView).setOnClickListener(v -> startActivity(new Intent(this, ImageViewActivity.class)));
        findViewById(R.id.btnScroll).setOnClickListener(v -> startActivity(new Intent(this, ScrollViewActivity.class)));
        findViewById(R.id.btnCustomToast).setOnClickListener(v -> startActivity(new Intent(this, CustomToastActivity.class)));
        findViewById(R.id.btnTimePicker).setOnClickListener(v -> startActivity(new Intent(this, TimePickerActivity.class)));
        findViewById(R.id.btnDatePicker).setOnClickListener(v -> startActivity(new Intent(this, DatePickerActivity.class)));
    }
}
