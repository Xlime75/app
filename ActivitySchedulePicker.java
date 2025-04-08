package com.example.studentscheduletracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.graphics.Color;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySchedulePicker extends AppCompatActivity {

    private Spinner spinnerCourses, spinnerSemester, spinnerSection, spinnerCourseCode;
    private Button btnViewSchedule, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_picker);

        spinnerCourses = findViewById(R.id.spinnerCourses);
        spinnerSemester = findViewById(R.id.spinnerSemester);
        spinnerSection = findViewById(R.id.spinnerSection);
        spinnerCourseCode = findViewById(R.id.spinnerCourseCode);
        btnViewSchedule = findViewById(R.id.btnViewSchedule);
        btnBack = findViewById(R.id.btnBack);

        // Initialize spinners
        setUpSpinner(spinnerCourses, new String[]{"Select course", "BSIT", "BSMT", "BSEE", "BSBA", "BSN", "BSED"});
        setUpSpinner(spinnerSemester, new String[]{"Select semester", "First", "Second", "Summer class"});
        setUpSpinner(spinnerSection, new String[]{"Select course first"});
        setUpSpinner(spinnerCourseCode, new String[]{"Select course and section and semester"});

        // Set Listeners
        spinnerCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateSectionsBasedOnCourse();
                updateCourseCodes();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinnerSection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateCourseCodes();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateCourseCodes();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Button listeners
        setUpButtonListeners();
    }

    // Custom Spinner Setup with Hint Support
    private void setUpSpinner(Spinner spinner, String[] items) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items) {
            @Override
            public boolean isEnabled(int position) {
                return position != 0; // Disable first item
            }

            @Override
            public View getDropDownView(int position, View convertView, android.view.ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textView = (TextView) view;
                if (position == 0) {
                    textView.setTextColor(Color.BLACK); // Hint color
                } else {
                    textView.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    // Dynamically update sections based on selected course
    private void updateSectionsBasedOnCourse() {
        String course = spinnerCourses.getSelectedItem().toString();
        String[] sections;

        if (course.equals("BSIT")) {
            sections = new String[]{
                    "Select your section",
                    "BSIT - 1A", "BSIT - 1B",
                    "BSIT - 2A", "BSIT - 2B",
                    "BSIT - 3A", "BSIT - 3B"
            };
        } else if (course.equals("BSMT")) {
            sections = new String[]{
                    "Select your section",
                    "BSMT - 1A", "BSMT - 1B",
                    "BSMT - 2A", "BSMT - 2B",
                    "BSMT - 3A", "BSMT - 3B"
            };
        } else if (course.equals("BSEE")) {
            sections = new String[]{
                    "Select your section",
                    "BSEE - 1A", "BSEE - 1B",
                    "BSEE - 2A", "BSEE - 2B",
                    "BSEE - 3A", "BSEE - 3B"
            };
        } else if (course.equals("BSBA")) {
            sections = new String[]{
                    "Select your section",
                    "BSBA - 1A", "BSBA - 1B",
                    "BSBA - 2A", "BSBA - 2B",
                    "BSBA - 3A", "BSBA - 3B"
            };
        } else if (course.equals("BSN")) {
            sections = new String[]{
                    "Select your section",
                    "BSN - 1A", "BSN - 1B",
                    "BSN - 2A", "BSN - 2B",
                    "BSN - 3A", "BSN - 3B"
            };
        } else if (course.equals("BSED")) {
            sections = new String[]{
                    "Select your section",
                    "BSED - 1A", "BSED - 1B",
                    "BSED - 2A", "BSED - 2B",
                    "BSED - 3A", "BSED - 3B"
            };
        }
        else {
            sections = new String[]{"Select course first"};
        }

        setUpSpinner(spinnerSection, sections);
    }

    // Update course codes based on section and semester
    private void updateCourseCodes() {
        String section = spinnerSection.getSelectedItem().toString();
        String semester = spinnerSemester.getSelectedItem().toString();

        String[] courseCodes;

        if ((section.equals("BSIT - 2A") || section.equals("BSIT - 2B")) && semester.equals("First")) {
            courseCodes = new String[]{
                    "Select course and section and semester",
                    "GEE 200 - Foreign Language 1",
                    "GEU 102 - Euthenics 2",
                    "GPE 103 - Individual/Dual Sports",
                    "IT 204 - Information Management",
                    "IT 205 - Quantitative Methods",
                    "IT-ELEC1 - Platform Technologies (Elective)",
                    "IT 200 - Object-Oriented Programming",
                    "IT 201 - Data Structures and Algorithms",
                    "IT 202 - Human Computer Interaction"
            };
        } else if ((section.equals("BSIT - 2A") || section.equals("BSIT - 2B")) && semester.equals("Second")) {
            courseCodes = new String[]{
                    "Select course and section and semester",
                    "GE 109 - Life and Works of Rizal",
                    "GEE 103 - Phil Popular Cultures With Asean Countries",
                    "GPE 104 - Team Sports",
                    "IT 203 - Data Communication and Networking",
                    "IT 206 - Advance Database Management System",
                    "IT 207 - Integrative Programming and Technologies",
                    "IT-ELEC2 - Web System and Technologies",
                    "IT 208 - IT Project Management"
            };
        } else {
            courseCodes = new String[]{"Course codes not yet available"};
            spinnerCourseCode.setEnabled(false);  // Disable spinner
        }

        setUpSpinner(spinnerCourseCode, courseCodes);

        // Enable course code spinner when a valid section is selected
        if (!courseCodes[0].equals("Course codes not yet available")) {
            spinnerCourseCode.setEnabled(true);
        }
    }

    // Button Logic
    private void setUpButtonListeners() {
        btnViewSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCourse = spinnerCourses.getSelectedItem().toString();
                String selectedSemester = spinnerSemester.getSelectedItem().toString();
                String selectedSection = spinnerSection.getSelectedItem().toString();
                String selectedCourseCode = spinnerCourseCode.getSelectedItem().toString();

                if (selectedCourse.equals("Select course") ||
                        selectedSemester.equals("Select semester") ||
                        selectedSection.equals("Select course first") ||
                        selectedSection.equals("Select your section") ||
                        selectedCourseCode.equals("Select course and section and semester") ||
                        selectedCourseCode.equals("Course codes not yet available")) {
                    Toast.makeText(ActivitySchedulePicker.this, "Please make valid selections for all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(ActivitySchedulePicker.this, ScheduleActivity.class);
                intent.putExtra("selectedCourseCode", selectedCourseCode);
                intent.putExtra("selectedSection", selectedSection);
                intent.putExtra("selectedSemester", selectedSemester);
                startActivity(intent);

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close Activity
            }
        });
    }
}
