package com.dao;

import com.model.Enrollment;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EnrollmentDAO {
	public void enrollStudent(Enrollment e) {
	    try {
	        Connection con = DBConnection.getConnection();

	        // 🔍 Check if already enrolled
	        String checkQuery = "SELECT * FROM enrollments WHERE student_id=? AND course_id=?";
	        PreparedStatement checkPs = con.prepareStatement(checkQuery);
	        checkPs.setInt(1, e.getStudentId());
	        checkPs.setInt(2, e.getCourseId());

	        ResultSet rs = checkPs.executeQuery();

	        if (rs.next()) {
	            System.out.println("Student already enrolled in this course ❌");
	            return;
	        }

	        // ✅ Insert if not exists
	        String query = "INSERT INTO enrollments(student_id, course_id) VALUES (?, ?)";
	        PreparedStatement ps = con.prepareStatement(query);

	        ps.setInt(1, e.getStudentId());
	        ps.setInt(2, e.getCourseId());

	        ps.executeUpdate();

	        System.out.println("Student Enrolled Successfully ✅");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}

    public void viewEnrollments() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT s.name, c.course_name " +
                           "FROM enrollments e " +
                           "JOIN students s ON e.student_id = s.id " +
                           "JOIN courses c ON e.course_id = c.course_id";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Enrolled Students ---");

            while (rs.next()) {
                System.out.println(
                    rs.getString("name") + " | " +
                    rs.getString("course_name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}