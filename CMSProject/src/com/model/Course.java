package com.model;

public class Course {

    private int courseId;
    private String courseName;
    private String duration;
    private double fees;

    // Constructor
    public Course(String courseName, String duration, double fees) {
        this.courseName = courseName;
        this.duration = duration;
        this.fees = fees;
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDuration() {
        return duration;
    }

    public double getFees() {
        return fees;
    }
}