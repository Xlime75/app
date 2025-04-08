package com.example.studentscheduletracker;

import java.util.List;
import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private List<Schedule> schedules;

    // Constructor
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.schedules = new ArrayList<>();
    }

    // Add schedule
    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
