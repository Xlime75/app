package com.example.studentscheduletracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScheduleActivity extends AppCompatActivity {

    private TextView txtCourseCode, txtSchedule, txtTimeAndDay;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule); // Ensure the layout is set correctly

        // Initialize UI components
        txtCourseCode = findViewById(R.id.courseCodeText);
        txtSchedule = findViewById(R.id.txtSchedule);
        txtTimeAndDay = findViewById(R.id.timeAndDayText);
        btnBack = findViewById(R.id.btnBack);

        // Retrieve data from the intent passed by ActivitySchedulePicker
        Intent intent = getIntent();
        String selectedCourseCode = intent.getStringExtra("selectedCourseCode");
        String selectedSection = intent.getStringExtra("selectedSection");
        String selectedSemester = intent.getStringExtra("selectedSemester");

        // Display the selected course code in TextView
        txtCourseCode.setText("Course Code: " + selectedCourseCode);

        // Get the schedule based on the selected course, but only for BSIT - 2B
        String[] scheduleDetails = getScheduleForCourse(selectedCourseCode, selectedSection, selectedSemester);

        // Display the schedule and time/day
        txtSchedule.setText(scheduleDetails[0]);
        txtTimeAndDay.setText(scheduleDetails[1]);

        // Back Button functionality
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Close this activity and go back to previous screen
            }
        });
    }

    // Method to return schedule details based on selected course code, section, and semester
    private String[] getScheduleForCourse(String courseCode, String section, String semester) {
        String[] details = new String[2]; // details[0] = Schedule, details[1] = Time and Day

        // Check if the section is "BSIT - 2B" before proceeding with the schedule
        if (section.equals("BSIT - 2B")) {
            // Schedule for BSIT - 2B First Semester
            if (semester.equals("First")) {
                switch (courseCode) {
                    case "GEE 200 - Foreign Language 1":
                        details[0] = "Schedule: Tuesday";
                        details[1] = "8:00 am - 11:00 am";
                        break;
                    case "GEU 102 - Euthenics 2":
                        details[0] = "Schedule: Saturday";
                        details[1] = "4:00 pm - 5:00 pm";
                        break;
                    case "GPE 103 - Individual/Dual Sports":
                        details[0] = "Schedule: Monday";
                        details[1] = "1:00 pm - 3:00 pm";
                        break;
                    case "IT 204 - Information Management":
                        details[0] = "Schedule: Wednesday";
                        details[1] = "7:00 am - 9:00 am (Lecture Online) & 10:00 am - 1:00 pm (Lab F2F)";
                        break;
                    case "IT 205 - Quantitative Methods":
                        details[0] = "Schedule: Tuesday";
                        details[1] = "11:00 am - 2:00 pm";
                        break;
                    case "IT-ELEC1 - Platform Technologies (Elective)":
                        details[0] = "Schedule: Monday & Wednesday";
                        details[1] = "1:00 pm - 3:00 pm (Lecture Online) & 3:00 pm - 6:00 pm (Lab F2F)";
                        break;
                    case "IT 200 - Object-Oriented Programming":
                        details[0] = "Schedule: Thursday";
                        details[1] = "1:00 pm - 3:00 pm (Lecture Online) & 3:00 pm - 6:00 pm (Lab F2F)";
                        break;
                    case "IT 201 - Data Structures and Algorithms":
                        details[0] = "Schedule: Tuesday & Thursday";
                        details[1] = "10:00 am - 12:00 pm (Lecture Online) & 3:00 pm - 6:00 pm (Lab F2F)";
                        break;
                    case "IT 202 - Human Computer Interaction":
                        details[0] = "Schedule: Monday & Thursday";
                        details[1] = "7:00 am - 10:00 am (Lab F2F) & 3:00 pm - 6:00 pm (Lecture Online)";
                        break;
                    default:
                        details[0] = "No schedule available for this course.";
                        details[1] = "Please select a valid course.";
                }
            }

            // Schedule for BSIT - 2B Second Semester
            else if (semester.equals("Second")) {
                switch (courseCode) {
                    case "GE 109 - Life and Works of Rizal":
                        details[0] = "Schedule: Friday";
                        details[1] = "2:00 pm - 5:00 pm";
                        break;
                    case "GEE 103 - Phil Popular Cultures With Asean Countries":
                        details[0] = "Schedule: Friday";
                        details[1] = "10:00 am - 1:00 pm";
                        break;
                    case "GPE 104 - Team Sports":
                        details[0] = "Schedule: Friday";
                        details[1] = "7:00 am - 10:00 am";
                        break;
                    case "IT 203 - Data Communication and Networking":
                        details[0] = "Schedule: Wednesday & Thursday";
                        details[1] = "7:00 am - 10:00 am (Lab F2F) & 6:00 pm - 8:00 pm (Lecture Online)";
                        break;
                    case "IT 206 - Advance Database Management System":
                        details[0] = "Schedule: Tuesday & Wednesday";
                        details[1] = "12:00 pm - 2:00 pm (Lecture Online) & 1:00 pm - 4:00 pm (Lab F2F)";
                        break;
                    case "IT 207 - Integrative Programming and Technologies":
                        details[0] = "Schedule: Saturday & Tuesday";
                        details[1] = "10:00 am - 1:00 pm (Lab F2F) & 5:00 pm - 7:00 pm (Lecture Online)";
                        break;
                    case "IT-ELEC2 - Web System and Technologies":
                        details[0] = "Schedule: Saturday & Tuesday";
                        details[1] = "7:00 am - 10:00 am (Lab F2F) & 8:00 am - 10:00 am (Lecture Online)";
                        break;
                    case "IT 208 - IT Project Management":
                        details[0] = "Schedule: Tuesday";
                        details[1] = "2:00 pm - 5:00 pm";
                        break;
                    default:
                        details[0] = "No schedule available for this course.";
                        details[1] = "Please select a valid course.";
                }
            }
        } else {
            // If the section is not "BSIT - 2B", display no schedule available
            details[0] = "No schedule available for this course.";
        }

        return details;
    }
}
