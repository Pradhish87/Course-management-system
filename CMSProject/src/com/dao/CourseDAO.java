package com.dao;

import com.model.Course;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseDAO {

    public void addCourse(Course c) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO courses(course_name, duration, fees) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, c.getCourseName());
            ps.setString(2, c.getDuration());
            ps.setDouble(3, c.getFees());

            ps.executeUpdate();

            System.out.println("Course Added ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewCourses() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM courses";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("course_id") + " | " +
                    rs.getString("course_name") + " | " +
                    rs.getString("duration") + " | " +
                    rs.getDouble("fees")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}