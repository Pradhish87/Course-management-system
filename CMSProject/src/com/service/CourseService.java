package com.service;

import com.dao.CourseDAO;
import com.model.Course;

public class CourseService {

    CourseDAO dao = new CourseDAO();

    public void addCourse(String name, String duration, double fees) {
        Course c = new Course(name, duration, fees);
        dao.addCourse(c);
    }

    public void showCourses() {
        dao.viewCourses();
    }
}