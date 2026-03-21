package com.service;

import com.dao.EnrollmentDAO;
import com.model.Enrollment;

public class EnrollmentService {

    EnrollmentDAO dao = new EnrollmentDAO();

    public void enrollStudent(int studentId, int courseId) {

        Enrollment e = new Enrollment(studentId, courseId);

        dao.enrollStudent(e);
    }
    public void showEnrollments() {
        dao.viewEnrollments();
    }
}