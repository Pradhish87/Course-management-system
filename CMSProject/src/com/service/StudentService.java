package com.service;

import com.dao.StudentDAO;
import com.model.Student;

public class StudentService {

    StudentDAO dao = new StudentDAO();

    public void registerStudent(String name, String email, String password) {

        // Validation
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be empty ❌");
            return;
        }

        if (email == null || email.trim().isEmpty()) {
            System.out.println("Email cannot be empty ❌");
            return;
        }
        
        if (!email.contains("@")) {
            System.out.println("Invalid email ❌");
            return;
        }

        if (password == null || password.trim().isEmpty()) {
            System.out.println("Password cannot be empty ❌");
            return;
        }

        Student s = new Student(name, email, password);
        dao.addStudent(s);
    }
    public void showStudents() {
        dao.viewStudents();
    }
    public void updateStudentName(int id, String name) {
        dao.updateName(id, name);
    }

    public void updateStudentEmail(int id, String email) {
        dao.updateEmail(id, email);
    }
    public void updateStudent(int id, String name, String email) {
        dao.updateStudent(id, name, email);
    }
    public void deleteStudent(int id) {
        dao.deleteStudent(id);
    }
    public void searchStudent(int id) {
        dao.searchStudent(id);
    }
    
}