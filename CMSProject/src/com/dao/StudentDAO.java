package com.dao;

import com.model.Student;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students(name, email, password) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());

            ps.executeUpdate();

            System.out.println("Student Added Successfully ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ THIS METHOD MUST BE INSIDE CLASS
    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateStudent(int id, String name, String email) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET name=?, email=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated ✅");
            } else {
                System.out.println("Student not found ❌");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted ✅");
            } else {
                System.out.println("Student not found ❌");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateName(int id, String name) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET name=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Name Updated ✅");
            } else {
                System.out.println("Student not found ❌");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateEmail(int id, String email) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET email=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Email Updated ✅");
            } else {
                System.out.println("Student not found ❌");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email")
                );
            } else {
                System.out.println("Student not found ❌");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getStudentsData() {
        StringBuilder data = new StringBuilder();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                data.append(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + "\n"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data.toString();
    }
    
}