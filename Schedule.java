package com.example.studentscheduletracker;

public class Schedule {
    private String time;
    private String day;

    // Constructor
    public Schedule(String time, String day) {
        this.time = time;
        this.day = day;
    }

    // Getters
    public String getTime() {
        return time;
    }

    public String getDay() {
        return day;
    }
}
