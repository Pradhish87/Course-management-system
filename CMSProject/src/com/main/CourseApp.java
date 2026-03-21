package com.main;

import com.service.StudentService;
import com.service.CourseService;
import com.service.EnrollmentService;
import java.util.Scanner;

public class CourseApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        while (true) {

            System.out.println("\n--- COURSE MANAGEMENT SYSTEM ---");
            System.out.printf("%-25s %-25s\n", "1. Add Student", "6. Add Course");
            System.out.printf("%-25s %-25s\n", "2. View Students", "7. View Courses");
            System.out.printf("%-25s %-25s\n", "3. Update Student", "8. Enroll Student");
            System.out.printf("%-25s %-25s\n", "4. Delete Student", "9. View Enrollments");
            System.out.printf("%-25s %-25s\n", "5. Search Student", "10. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    service.registerStudent(name, email, password);
                    break;

                case 2:
                    service.showStudents();
                    break;
                    
                case 3:
                    System.out.print("Enter Student ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("1. Update Name");
                    System.out.println("2. Update Email");

                    System.out.print("Choose option: ");
                    int option = sc.nextInt();
                    sc.nextLine();

                    if (option == 1) {
                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        service.updateStudentName(uid, newName);

                    } else if (option == 2) {
                        System.out.print("Enter New Email: ");
                        String newEmail = sc.nextLine();

                        service.updateStudentEmail(uid, newEmail);

                    } else {
                        System.out.println("Invalid option ❌");
                    }

                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    service.deleteStudent(did);
                    break;
                    
                case 5:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();

                    service.searchStudent(searchId);
                    break;
                    
                case 6:
                    System.out.print("Enter Course Name: ");
                    String cname = sc.nextLine();

                    System.out.print("Enter Duration: ");
                    String duration = sc.nextLine();

                    System.out.print("Enter Fees: ");
                    double fees = sc.nextDouble();

                    courseService.addCourse(cname, duration, fees);
                    break;

                case 7:
                    courseService.showCourses();
                    break;
                    
                case 8:
                    System.out.print("Enter Student ID: ");
                    int enrollId = sc.nextInt();

                    System.out.print("Enter Course ID: ");
                    int courseId = sc.nextInt();

                    enrollmentService.enrollStudent(enrollId, courseId);
                    break;
                    
                case 9:
                    enrollmentService.showEnrollments();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);
                    
                

                default:
                    System.out.println("Invalid choice ❌");
            }
        }
    }
}