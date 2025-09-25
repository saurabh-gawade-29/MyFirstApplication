package com.example.myfirstapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etAddress;
    ImageView ivProfile;
    ImageButton ibEditPhoto;
    RadioGroup rgGender;
    CheckBox cbSports, cbMusic, cbReading;
    ToggleButton tgNewsletter;
    DatePicker datePicker;
    TimePicker timePicker;
    ListView listView;
    GridView gridView;
    ProgressBar progressBar;
    Button btnSubmit, btnReset;
    LinearLayout customToastLayout;
    TextView toastText;

    // sample data
    String[] courses = new String[] {
            "Mathematics", "Physics", "Chemistry", "Biology",
            "Computer Science", "English", "History"
    };
    String[] days = new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

    // track simple selections
    int selectedDayIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);

        ivProfile = findViewById(R.id.ivProfile);
        ibEditPhoto = findViewById(R.id.ibEditPhoto);

        rgGender = findViewById(R.id.rgGender);

        cbSports = findViewById(R.id.cbSports);
        cbMusic = findViewById(R.id.cbMusic);
        cbReading = findViewById(R.id.cbReading);

        tgNewsletter = findViewById(R.id.tgNewsletter);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);

        progressBar = findViewById(R.id.progressBar);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);

        customToastLayout = findViewById(R.id.custom_toast);
        toastText = findViewById(R.id.toastText);

        // ListView adapter (single-choice)
        ArrayAdapter<String> lvAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_single_choice, courses);
        listView.setAdapter(lvAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // GridView adapter
        ArrayAdapter<String> gvAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, days);
        gridView.setAdapter(gvAdapter);

        // Grid item clicked -> track selection
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            selectedDayIndex = position;
            // highlight manually (simple approach)
            for (int i = 0; i < parent.getChildCount(); i++) {
                parent.getChildAt(i).setSelected(i == position);
            }
            updateProgressBar();
        });

        // text watchers to update progress
        TextWatcher watcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int st, int c, int a) {}
            public void onTextChanged(CharSequence s, int st, int b, int c) {}
            public void afterTextChanged(Editable s) { updateProgressBar(); }
        };
        etName.addTextChangedListener(watcher);
        etEmail.addTextChangedListener(watcher);
        etPhone.addTextChangedListener(watcher);

        // checkboxes & radio -> progress
        cbSports.setOnCheckedChangeListener((buttonView, isChecked) -> updateProgressBar());
        cbMusic.setOnCheckedChangeListener((buttonView, isChecked) -> updateProgressBar());
        cbReading.setOnCheckedChangeListener((buttonView, isChecked) -> updateProgressBar());
        rgGender.setOnCheckedChangeListener((group, checkedId) -> updateProgressBar());
        listView.setOnItemClickListener((parent, view, position, id) -> updateProgressBar());

        // ImageButton: simple demo action (swap placeholder)
        ibEditPhoto.setOnClickListener(v -> ivProfile.setImageResource(android.R.drawable.ic_menu_camera));

        // Submit button
        btnSubmit.setOnClickListener(v -> {
            updateProgressBar();
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill Name, Email and Phone", Toast.LENGTH_SHORT).show();
                return;
            }

            // gender
            String gender = "Not specified";
            int gid = rgGender.getCheckedRadioButtonId();
            if (gid != -1) {
                RadioButton rb = findViewById(gid);
                gender = rb.getText().toString();
            }

            // interests
            StringBuilder interests = new StringBuilder();
            if (cbSports.isChecked()) interests.append("Sports, ");
            if (cbMusic.isChecked()) interests.append("Music, ");
            if (cbReading.isChecked()) interests.append("Reading, ");
            String interestsStr = interests.length() > 0 ? interests.substring(0, interests.length()-2) : "None";

            // selected course
            int coursePos = listView.getCheckedItemPosition();
            String course = coursePos != ListView.INVALID_POSITION ? courses[coursePos] : "None";

            // day selection
            String day = selectedDayIndex >= 0 ? days[selectedDayIndex] : "None";

            // dob & time
            String dob = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            // summary
            String summary = "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone +
                    "\nGender: " + gender + "\nInterests: " + interestsStr +
                    "\nCourse: " + course + "\nAvailable Day: " + day +
                    "\nDOB: " + dob + "\nContact Time: " + hour + ":" + String.format("%02d", minute) +
                    "\nNewsletter: " + (tgNewsletter.isChecked() ? "Yes" : "No");

            // Show confirmation dialog
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Confirm submission")
                    .setMessage(summary)
                    .setPositiveButton("OK", (dialog, which) -> {
                        // show custom toast using hidden layout in same XML
                        toastText.setText("Registration submitted for " + name);
                        Toast toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(customToastLayout); // uses same single-XML
                        toast.show();
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });

        // Reset button
        btnReset.setOnClickListener(v -> {
            etName.setText("");
            etEmail.setText("");
            etPhone.setText("");
            etAddress.setText("");
            rgGender.clearCheck();
            cbSports.setChecked(false);
            cbMusic.setChecked(false);
            cbReading.setChecked(false);
            tgNewsletter.setChecked(false);
            listView.clearChoices();
            for (int i = 0; i < listView.getCount(); i++) listView.setItemChecked(i, false);
            selectedDayIndex = -1;
            // reset progress
            progressBar.setProgress(0);
        });

        // initial update
        updateProgressBar();
    }

    private void updateProgressBar() {
        int total = 7; // fields we consider for completion
        int done = 0;
        if (!etName.getText().toString().trim().isEmpty()) done++;
        if (!etEmail.getText().toString().trim().isEmpty()) done++;
        if (!etPhone.getText().toString().trim().isEmpty()) done++;
        if (rgGender.getCheckedRadioButtonId() != -1) done++;
        if (cbSports.isChecked() || cbMusic.isChecked() || cbReading.isChecked()) done++;
        if (listView.getCheckedItemPosition() != ListView.INVALID_POSITION) done++;
        if (selectedDayIndex >= 0) done++;

        int percent = (int) ((done / (float) total) * 100);
        progressBar.setProgress(percent);
    }
}